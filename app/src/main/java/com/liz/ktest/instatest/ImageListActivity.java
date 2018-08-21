package com.liz.ktest.instatest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ImageListActivity extends AppCompatActivity {

    public static final String EXTRA_ACCESS_TOKEN = "EXTRA_ACCESS_TOKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list_activity);
    }

    public static void go(Context context, String accessToken) {
        Intent intent = new Intent(context, ImageListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(EXTRA_ACCESS_TOKEN, accessToken);
        context.startActivity(intent);
    }
}
