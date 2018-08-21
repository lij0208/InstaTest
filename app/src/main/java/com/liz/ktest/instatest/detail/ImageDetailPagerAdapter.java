package com.liz.ktest.instatest.detail;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.model.ImageInfo;

import java.util.List;

public class ImageDetailPagerAdapter extends PagerAdapter {

    private List<ImageInfo> imageInfoList;

    public ImageDetailPagerAdapter(List<ImageInfo> imageInfoList) {
        this.imageInfoList = imageInfoList;
    }

    @Override
    public int getCount() {
        return imageInfoList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_detail_view, null, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(container.getContext()).load(imageInfoList.get(position).url()).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}