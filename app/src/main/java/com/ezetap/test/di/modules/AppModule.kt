package com.ezetap.test.di.modules

import android.app.Application
import android.content.Context
import com.ezetap.test.di.modules.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(
    includes = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        NetModule::class,
        DataModule::class,
    ]
)
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: Application): Context = application

}
