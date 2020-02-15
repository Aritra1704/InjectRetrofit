package com.arpaul.networkmodule.di.component;

import com.arpaul.networkmodule.di.module.RetrofitModule;
import com.arpaul.networkmodule.di.scopes.LibScope;
import com.arpaul.networkmodule.network.RetrofitService;

import javax.inject.Singleton;

import dagger.Component;

@LibScope
@Component(modules = {
        RetrofitModule.class
})
public interface LibComponent {
    RetrofitService inject(RetrofitService activity);

    RetrofitService getRetrofit();

}
