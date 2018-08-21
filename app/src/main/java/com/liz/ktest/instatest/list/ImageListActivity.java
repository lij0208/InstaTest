package com.liz.ktest.instatest.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.RetroManager;
import com.liz.ktest.instatest.model.RecentData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageListActivity extends AppCompatActivity {

    public static final String EXTRA_ACCESS_TOKEN = "EXTRA_ACCESS_TOKEN";
    public static final int SPAN_COUNT = 3;
    private RecyclerView recyclerView;
    private InstaAdapter adapter;

    private String accessToken = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list_activity);
        getArgs();
        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
        getRecentData();
    }

    public static void go(Context context, String accessToken) {
        Intent intent = new Intent(context, ImageListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(EXTRA_ACCESS_TOKEN, accessToken);
        context.startActivity(intent);
    }

    private void getArgs() {

        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        accessToken = intent.getStringExtra(EXTRA_ACCESS_TOKEN);
    }


    private void initRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new InstaAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getRecentData() {

        Call<RecentData> call = RetroManager.createInstagramRetrofit().getRecent(accessToken);
        call.enqueue(new Callback<RecentData>() {
            @Override
            public void onResponse(Call<RecentData> call, Response<RecentData> response) {
                adapter.setRecentList(response.body().data());
            }

            @Override
            public void onFailure(Call<RecentData> call, Throwable t) {
                int a = 0;
            }
        });
    }
}
