package com.liz.ktest.instatest.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import io.reactivex.annotations.Nullable;

@AutoValue
public abstract class Carousel implements Parcelable {

    public static Builder builder() {
        return new AutoValue_Carousel.Builder();
    }
    public static TypeAdapter<Carousel> typeAdapter(Gson gson) {
        return new AutoValue_Carousel.GsonTypeAdapter(gson);
    }

    @Nullable
    public abstract Image images();

    @Nullable
    public abstract Image videos();

    public abstract String type();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder images(Image images);

        public abstract Builder videos(Image videos);

        public abstract Builder type(String type);

        public abstract Carousel build();
    }
}
