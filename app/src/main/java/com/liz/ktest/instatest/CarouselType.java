package com.liz.ktest.instatest;

public enum CarouselType {
    IMAGE("image"),
    VIDEO("video");

    String type;

    CarouselType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
