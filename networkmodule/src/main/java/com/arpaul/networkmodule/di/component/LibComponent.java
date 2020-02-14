package com.arpaul.networkmodule.di.component;

import com.arpaul.networkmodule.di.module.RetrofitModule;
import com.arpaul.networkmodule.network.RetrofitService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RetrofitModule.class
})
public interface LibComponent {
    RetrofitService inject(RetrofitService activity);

    RetrofitService getRetrofit();

}
