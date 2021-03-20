package com.ezetap.test

import android.app.Application
import com.ezetap.test.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class EzetapApp : Application(), HasAndroidInjector {

    /**
     * Injector for Android components
     */
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    /**
     * See [Application.onCreate]
     */
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().app(this)
            .build()
            .inject(this)
    }

    /**
     * @return injector for Android components
     */
    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
