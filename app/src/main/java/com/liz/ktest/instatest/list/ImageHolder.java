package com.liz.ktest.instatest.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.model.Recent;
import com.liz.ktest.instatest.utils.StringUtils;

public class ImageHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView morePhotoCountTv;

    public ImageHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        morePhotoCountTv = itemView.findViewById(R.id.morePhotoCountTv);
    }

    public void bind(final Recent recent) {

        Glide.with(itemView.getContext()).load(recent.images().lowResolution().url()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ImageDetailActivity.go(v.getContext(), getImageClickUrl(element));
            }
        });

        if (recent.carousel() != null && recent.carousel().size() > 0) {

            morePhotoCountTv.setText(StringUtils.getString(R.string.count, recent.carousel().size()));
            morePhotoCountTv.setVisibility(View.VISIBLE);
        }
        else {
            morePhotoCountTv.setVisibility(View.GONE);
        }

    }
}
