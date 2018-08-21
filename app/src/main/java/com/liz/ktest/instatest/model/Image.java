package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.Nullable;

@AutoValue
public abstract class Image implements Parcelable {

    public static TypeAdapter<Image> typeAdapter(Gson gson) {
        return new AutoValue_Image.GsonTypeAdapter(gson);
    }

    public abstract ImageInfo thumbnail();

    @SerializedName("low_resolution")
    public abstract ImageInfo lowResolution();

    @SerializedName("standard_resolution")
    public abstract ImageInfo standardResolution();

    @Nullable
    public abstract String type();
}
