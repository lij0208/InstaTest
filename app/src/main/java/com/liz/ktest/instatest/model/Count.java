package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Count implements Parcelable {

    public static TypeAdapter<Count> typeAdapter(Gson gson) {
        return new AutoValue_Count.GsonTypeAdapter(gson);
    }

    public abstract int count();
}
