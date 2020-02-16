package com.arpaul.extmodule.di.modules;

import com.arpaul.extmodule.ExtContract;
import com.arpaul.extmodule.MFEImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MFEImplModule {
    @Provides
    ExtContract provideMferImpl() {
        return new ExtContractPojo();
    }

    class ExtContractPojo implements ExtContract {
        @Override
        public void getExtData() {

        }
    }
}
