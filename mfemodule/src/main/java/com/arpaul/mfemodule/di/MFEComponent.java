package com.arpaul.mfemodule.di;

import com.arpaul.mfemodule.MFEContract;
import com.arpaul.mfemodule.di.modules.MFEModule;
import com.arpaul.mfemodule.di.scopes.MFEScope;

import dagger.Subcomponent;

@MFEScope
@Subcomponent(modules = {MFEModule.class})
public interface MFEComponent {
    void inject(MFEModule activity);

    MFEContract getMFEContract();
}
