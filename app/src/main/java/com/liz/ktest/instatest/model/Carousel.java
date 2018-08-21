package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Carousel implements Parcelable {

    public static TypeAdapter<Carousel> typeAdapter(Gson gson) {
        return new AutoValue_Carousel.GsonTypeAdapter(gson);
    }

    public abstract Image images();
}
