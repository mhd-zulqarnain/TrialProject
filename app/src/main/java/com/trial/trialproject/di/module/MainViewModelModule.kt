package com.trial.trialproject.di.module

import androidx.lifecycle.ViewModel
import com.trial.trialproject.di.utils.ViewModelKey
import com.trial.trialproject.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule
{
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun productDetailsViewModel(productViewModel: MainViewModel): ViewModel
}