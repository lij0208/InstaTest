package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class RecentData implements Parcelable{

    public static TypeAdapter<RecentData> typeAdapter(Gson gson) {
        return new AutoValue_RecentData.GsonTypeAdapter(gson);
    }

    public abstract List<Recent> data();
}
