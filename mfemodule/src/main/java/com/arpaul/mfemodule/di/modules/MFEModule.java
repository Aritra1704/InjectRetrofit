package com.arpaul.mfemodule.di.modules;

import com.arpaul.mfemodule.MFEContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MFEModule {
    @Provides
    MFEContract provideMferImpl() {
        return new MfeContractPojo();
    }

    class MfeContractPojo implements MFEContract {
        @Override
        public void getMFEData() {

        }
    }
}
