package com.ezetap.test.di.modules

import android.app.Application
import com.ezetap.test.data.EzetapDatabase
import com.ezetap.test.data.customUi.dao.CustomUiDao
import dagger.Module
import dagger.Provides

/**
 * Data module
 */
@Module
class DataModule {

    @Module
    companion object {
        /**
         * [CustomUiDao]
         */
        @JvmStatic
        @Provides
        fun provideAssetDao(application: Application): CustomUiDao =
            EzetapDatabase.getInstance(application).customUiDao()
    }
}
