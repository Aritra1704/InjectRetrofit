package com.arpaul.networkmodule.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {
    @GET("employees")
    Call<String> getData();
}
