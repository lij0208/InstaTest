package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class From implements Parcelable {

    public static TypeAdapter<From> typeAdapter(Gson gson) {
        return new AutoValue_From.GsonTypeAdapter(gson);
    }

    @SerializedName("username")
    public abstract String username();

    @SerializedName("full_name")
    public abstract String fullName();

    @SerializedName("profile_picture")
    public abstract String profilePicture();

    @SerializedName("id")
    public abstract String id();
}
