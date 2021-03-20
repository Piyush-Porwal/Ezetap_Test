package com.ezetap.test.di

import com.ezetap.test.MainActivity
import com.ezetap.test.di.bindings.FragmentBindings
import com.ezetap.test.di.bindings.ViewModelBindings
import com.ezetap.test.utils.async.ThreadManager
import com.ezetap.test.utils.async.ThreadManagerImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {

    @ContributesAndroidInjector(
        modules = [
            FragmentBindings::class,
            ViewModelBindings::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @Binds
    abstract fun provideThreadManager(threadManager: ThreadManagerImpl): ThreadManager
}

