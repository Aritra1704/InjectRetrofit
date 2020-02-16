package com.arpaul.injectretrofit.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.arpaul.injectretrofit.common.AppPref;
import com.arpaul.injectretrofit.di.scopes.AppScope;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefModule {
    private Application application;

    @Inject
    public PrefModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application getApplication() {
        return application;
    }

    @AppScope
    @Provides
    public AppPref provideAppPreference() {
        return new AppPref(application);
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPref(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
