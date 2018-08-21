package com.liz.ktest.instatest.network;

import com.liz.ktest.instatest.model.RecentData;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroInstagram {

    @GET("v1/users/self/media/recent/")
    Call<RecentData> getRecent(@Query("access_token") String accessToken);
}
