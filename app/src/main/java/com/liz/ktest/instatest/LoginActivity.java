package com.liz.ktest.instatest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.liz.ktest.instatest.list.ImageListActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String REDIRECT_URL = "http://localhost/instagram-signin";
    private static final String CLIENT_ID = "3929b8713475485092f14273729c3c4c";
    private static final String RESPONSE_TYPE = "token";
    private static final String KEY_ACCESS_TOKEN = "access_token";

    private ImageView logoIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logoIv = findViewById(R.id.logoIv);
        logoIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(createLoginUri());
            }
        });
        checkForInstagramData();
    }

    private void saveAccessToken(String accessToken) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.apply();
    }

    private void login(String loginUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loginUrl));
        startActivity(intent);
    }

    private String createLoginUri() {
        return getString(R.string.instagram_login_uri, CLIENT_ID, REDIRECT_URL, RESPONSE_TYPE);
    }

    private void checkForInstagramData() {

        final Uri data = getIntent().getData();
        if(data != null && data.toString().startsWith(REDIRECT_URL) && data.getFragment() != null) {

            final String accessToken = data.getFragment().replaceFirst(KEY_ACCESS_TOKEN + "=", "");
            if (accessToken != null) {
                saveAccessToken(accessToken);
                ImageListActivity.go(this, accessToken);
                finish();
            } else {
                saveAccessToken("");
            }
        }
    }
}
