package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class User implements Parcelable {

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }

    public abstract String id();

    @SerializedName("full_name")
    public abstract String fullName();

    public abstract String username();

    @SerializedName("profile_picture")
    public abstract String profilePicture();
}