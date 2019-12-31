package com.trial.trialproject.di.module

import dagger.Module
import androidx.lifecycle.ViewModelProvider
import com.trial.trialproject.di.utils.ViewModelFactory
import dagger.Binds
import javax.inject.Singleton


@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
