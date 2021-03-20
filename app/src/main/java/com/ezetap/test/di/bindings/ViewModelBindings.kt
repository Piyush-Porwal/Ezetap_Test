package com.ezetap.test.di.bindings

import androidx.lifecycle.ViewModel
import com.ezetap.test.di.modules.viewmodel.ViewModelKey
import com.ezetap.test.ui.customUi.CustomUiViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBindings {

    @Binds
    @IntoMap
    @ViewModelKey(CustomUiViewModel::class)
    abstract fun bindCustomUiViewModel(viewModel: CustomUiViewModel): ViewModel
}
