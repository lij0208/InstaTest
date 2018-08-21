package com.liz.ktest.instatest;

public enum RecentType {
    IMAGE("image"),
    VIDEO("video"),
    CAROUSEL("carousel");

    String type;

    RecentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
