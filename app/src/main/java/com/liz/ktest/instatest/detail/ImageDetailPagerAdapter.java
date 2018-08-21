package com.liz.ktest.instatest.detail;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.liz.ktest.instatest.CarouselType;
import com.liz.ktest.instatest.GlobalApplication;
import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.model.Carousel;
import com.liz.ktest.instatest.model.ImageInfo;

import java.util.List;

public class ImageDetailPagerAdapter extends PagerAdapter {

    private List<Carousel> imageInfoList;

    public ImageDetailPagerAdapter(List<Carousel> imageInfoList) {
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
        ImageView playIv = view.findViewById(R.id.playIv);
        if (CarouselType.IMAGE.getType().toLowerCase().equals(imageInfoList.get(position).type())) {
            Glide.with(container.getContext()).load(imageInfoList.get(position).images().standardResolution().url()).into(imageView);
            playIv.setVisibility(View.GONE);
        }
        else if (CarouselType.VIDEO.getType().toLowerCase().equals(imageInfoList.get(position).type())){
            Glide.with(container.getContext()).load(imageInfoList.get(position).videos().standardResolution().url()).into(imageView);
            playIv.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(v -> playVideo(imageInfoList.get(position).videos().standardResolution().url()));
        }
        container.addView(view);
        return view;
    }

    private void playVideo(String uriStr) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(uriStr);
        intent.setDataAndType(uri, "video/*");
        ComponentName resolveActivity = intent.resolveActivity(GlobalApplication.getInstance().getPackageManager());
        if (resolveActivity != null) {
            GlobalApplication.getInstance().startActivity(intent);
        } else {
            Toast.makeText(GlobalApplication.getInstance(), "실행할 수 있는 앱이 없습니다.", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
