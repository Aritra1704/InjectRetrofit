package com.arpaul.injectretrofit.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {
    @GET("employees")
    Call<String> getData();
}
