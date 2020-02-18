package com.arpaul.injectretrofit.common;

import android.app.Application;

import androidx.annotation.UiThread;

import com.arpaul.extmodule.di.ExtComponent;
import com.arpaul.extmodule.di.modules.MFEExtImplModule;
import com.arpaul.injectretrofit.di.component.AppComponent;
import com.arpaul.injectretrofit.di.component.DaggerAppComponent;
import com.arpaul.injectretrofit.di.module.PrefModule;
import com.arpaul.injectretrofit.extImpls.ExtImpl;
import com.arpaul.networkmodule.di.component.DaggerLibComponent;
import com.arpaul.networkmodule.di.component.LibComponent;

import javax.inject.Inject;

public class AppInstance extends Application {
    private String TAG = AppInstance.class.getSimpleName();

    @Inject
    protected AppPref appPref;

    private AppComponent component;
    private LibComponent libComponent;

    @Override
    public void onCreate() {
        libComponent = DaggerLibComponent.builder().build();
        component = DaggerAppComponent
                .builder()
                .prefModule(new PrefModule(this))
                .libComponent(libComponent)
                .build();
        component.inject(this);
        ExtComponent extComponent = component.getExtComponent(new MFEExtImplModule());
        
        super.onCreate();
    }

    @UiThread
    public AppComponent getAppComponent() {
        return component;
    }

    public LibComponent getLibComponent() {
        return libComponent;
    }
}
