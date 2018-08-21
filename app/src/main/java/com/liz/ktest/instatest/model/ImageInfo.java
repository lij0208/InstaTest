package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ImageInfo implements Parcelable {

    public static TypeAdapter<ImageInfo> typeAdapter(Gson gson) {
        return new AutoValue_ImageInfo.GsonTypeAdapter(gson);
    }
    public abstract String url();

    public abstract int width();

    public abstract int height();
}