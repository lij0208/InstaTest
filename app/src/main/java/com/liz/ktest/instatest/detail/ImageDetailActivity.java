package com.liz.ktest.instatest.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.model.ImageInfo;

import java.util.ArrayList;
import java.util.List;

public class ImageDetailActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_LIST = "EXTRA_IMAGE_LIST";

    private List<ImageInfo> imageInfoList;
    private ViewPager pager;
    private ImageDetailPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_activity);
        pager = findViewById(R.id.viewPager);
        getArgs();
        initPagerAdapter();
    }

    private void initPagerAdapter() {
        adapter = new ImageDetailPagerAdapter(imageInfoList);
        pager.setAdapter(adapter);
    }

    public static void go(Context context, ArrayList<ImageInfo> imageInfoList) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(EXTRA_IMAGE_LIST, imageInfoList);
        context.startActivity(intent);
    }

    private void getArgs() {

        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        imageInfoList = intent.getParcelableArrayListExtra(EXTRA_IMAGE_LIST);
    }
}
