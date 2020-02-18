package com.arpaul.injectretrofit.di.component;

import com.arpaul.extmodule.di.ExtComponent;
import com.arpaul.extmodule.di.modules.MFEExtImplModule;
import com.arpaul.injectretrofit.common.AppInstance;
import com.arpaul.injectretrofit.common.AppPref;
import com.arpaul.injectretrofit.di.scopes.AppScope;
import com.arpaul.injectretrofit.di.module.PrefModule;
import com.arpaul.injectretrofit.extImpls.ExtImpl;
import com.arpaul.networkmodule.di.component.LibComponent;

import dagger.Component;

@AppScope
@Component(modules = {
        PrefModule.class
}, dependencies = LibComponent.class)
public interface AppComponent {
    void inject(AppInstance appInstance);

    AppPref getAppPref();

    ExtComponent getExtComponent(MFEExtImplModule module);

}
