package com.liz.ktest.instatest.utils;

import android.support.annotation.StringRes;

import com.liz.ktest.instatest.GlobalApplication;

public class StringUtils {

    public static String getString(@StringRes int id) {
        return GlobalApplication.getInstance().getString(id);
    }

    public static String getString(@StringRes int id, Object... args) {
        return GlobalApplication.getInstance().getString(id, args);
    }
}
