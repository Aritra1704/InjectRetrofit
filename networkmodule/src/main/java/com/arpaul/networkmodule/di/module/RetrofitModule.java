package com.arpaul.networkmodule.di.module;

import com.arpaul.networkmodule.network.RetrofitService;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {
    @Provides
    RetrofitService provideRetrofitService() {
        return new RetrofitService();
    }

//    @Provides
//    APICall provideApiCall() {
//        return RetrofitService.createService(APICall.class);
//    }
}
