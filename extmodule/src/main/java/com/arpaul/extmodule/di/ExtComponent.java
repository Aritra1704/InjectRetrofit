package com.arpaul.extmodule.di;

import com.arpaul.extmodule.ExtContract;
import com.arpaul.extmodule.MFEImpl;
import com.arpaul.extmodule.di.modules.MFEImplModule;
import com.arpaul.extmodule.di.scopes.ExtScope;
import com.arpaul.mfemodule.di.MFEComponent;
import com.arpaul.mfemodule.di.modules.MFEModule;

import dagger.Subcomponent;

@ExtScope
@Subcomponent(modules = {MFEImplModule.class})
public interface ExtComponent {
    MFEImpl inject(MFEImpl activity);

    ExtContract getExtContract();

//    MFEComponent getMfeComponent(MFEModule module);
}
