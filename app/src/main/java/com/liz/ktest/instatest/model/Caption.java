package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Caption implements Parcelable {
    public static TypeAdapter<Caption> typeAdapter(Gson gson) {
        return new AutoValue_Caption.GsonTypeAdapter(gson);
    }

    @SerializedName("created_time")
    public abstract String createdTime();

    public abstract String text();

    public abstract From from();

    public abstract String id();

}