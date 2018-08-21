package com.liz.ktest.instatest.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liz.ktest.instatest.CarouselType;
import com.liz.ktest.instatest.GlobalApplication;
import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.RecentType;
import com.liz.ktest.instatest.detail.ImageDetailActivity;
import com.liz.ktest.instatest.model.Carousel;
import com.liz.ktest.instatest.model.ImageInfo;
import com.liz.ktest.instatest.model.Recent;
import com.liz.ktest.instatest.utils.StringUtils;

import java.util.ArrayList;

public class ImageHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView morePhotoCountTv;

    private Recent recent;
    private ArrayList<Carousel> imageInfoList = new ArrayList<>();

    public ImageHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        morePhotoCountTv = itemView.findViewById(R.id.morePhotoCountTv);

        imageView.setOnClickListener(v -> {
            initImageList();
            ImageDetailActivity.go(GlobalApplication.getInstance(), imageInfoList);
        });
    }

    private void initImageList() {

        imageInfoList.clear();
        if (RecentType.VIDEO.getType().toLowerCase().equals(recent.type())) {
            imageInfoList.add(Carousel.builder().videos(recent.videos()).type(CarouselType.VIDEO.getType()).build());
        }
        else if (RecentType.CAROUSEL.getType().toLowerCase().equals(recent.type())) {
            imageInfoList.addAll(recent.carousel());
        }
        else {
            imageInfoList.add(Carousel.builder().videos(recent.images()).type(CarouselType.IMAGE.getType()).build());
        }
    }

    public void bind(final Recent recent) {
        this.recent = recent;
        Glide.with(itemView.getContext()).load(recent.images().lowResolution().url()).into(imageView);

        if (isCarouseEmpty(recent)) {
            morePhotoCountTv.setVisibility(View.GONE);
        }
        else {
            morePhotoCountTv.setText(StringUtils.getString(R.string.count, recent.carousel().size()));
            morePhotoCountTv.setVisibility(View.VISIBLE);
        }
    }

    private boolean isCarouseEmpty(Recent recent) {
        return recent.carousel() == null || recent.carousel().size() <= 0;
    }
}
