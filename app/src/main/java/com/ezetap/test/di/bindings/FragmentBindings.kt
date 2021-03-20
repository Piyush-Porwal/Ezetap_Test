package com.ezetap.test.di.bindings

import com.ezetap.test.ui.customUi.CustomUiFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindings {

    @ContributesAndroidInjector
    abstract fun contributeCustomUiFragment(): CustomUiFragment
}
