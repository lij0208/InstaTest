package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.annotations.Nullable;

@AutoValue
public abstract class Recent implements Parcelable {

    public static TypeAdapter<Recent> typeAdapter(Gson gson) {
        return new AutoValue_Recent.GsonTypeAdapter(gson);
    }

    public abstract String id();

    public abstract User user();

    public abstract Image images();

    @SerializedName("created_time")
    public abstract String createdTime();

    @Nullable
    public abstract Caption caption();

    public abstract Count likes();

    @Nullable
    public abstract List<String> tags();

    public abstract Count comments();

    public abstract String link();

    @Nullable
    @SerializedName("carousel_media")
    public abstract List<Carousel> carousel();

    public abstract String type();

    public abstract String filter();
}