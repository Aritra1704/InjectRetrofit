package com.arpaul.injectretrofit.di.component;

import com.arpaul.injectretrofit.common.AppInstance;
import com.arpaul.injectretrofit.common.AppPref;
import com.arpaul.injectretrofit.di.AppScope;
import com.arpaul.injectretrofit.di.module.PrefModule;
import com.arpaul.networkmodule.di.component.LibComponent;
import com.arpaul.networkmodule.network.RetrofitService;

import javax.inject.Singleton;

import dagger.Component;

@AppScope
@Component(modules = {
        PrefModule.class
}, dependencies = LibComponent.class)
public interface AppComponent {
    void inject(AppInstance appInstance);

    AppPref getAppPref();

}
