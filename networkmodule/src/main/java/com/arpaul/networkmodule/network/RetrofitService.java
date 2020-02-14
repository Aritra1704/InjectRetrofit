package com.arpaul.networkmodule.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    public static Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
            .baseUrl("http://dummy.restapiexample.com/api/v1/")
            .client(getOkHttpClient(getHttpLoggingInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    private static OkHttpClient getOkHttpClient(HttpLoggingInterceptor logger) {
        return new OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        if (BuildConfig.DEBUG)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        else
//            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);//add None for prod env
        return interceptor;
    }
}
