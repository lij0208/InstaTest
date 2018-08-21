package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Location implements Parcelable {
    public static TypeAdapter<Location> typeAdapter(Gson gson) {
        return new AutoValue_Location.GsonTypeAdapter(gson);
    }

    public abstract long latitude();

    public abstract long longitude();

    public abstract String id();

    @SerializedName("street_address")
    public abstract String street_address();

    public abstract String name();
}