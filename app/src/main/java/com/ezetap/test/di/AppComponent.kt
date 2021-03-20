package com.ezetap.test.di

import android.app.Application
import com.ezetap.test.EzetapApp
import com.ezetap.test.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppBindings::class
    ]
)
interface AppComponent : AndroidInjector<EzetapApp> {
    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: Application): Builder

        fun build(): AppComponent
    }
}
