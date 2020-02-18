package com.arpaul.extmodule.di.modules;

import com.arpaul.extmodule.ExtContract;
import com.arpaul.extmodule.MFEImpl;
import com.arpaul.mfemodule.di.MFEComponent;

import dagger.Module;
import dagger.Provides;

@Module
public class MFEExtImplModule {
    @Provides
    ExtContract provideMfeExtImpl() {
        return new ExtContractPojo();
    }

    class ExtContractPojo implements ExtContract {
        @Override
        public void getExtData() {

        }
    }

//    @Provides
//    MFEComponent getMFEComponent() {
//
//    }
}
