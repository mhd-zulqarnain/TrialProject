package com.trial.trialproject.di

import com.trial.trialproject.di.module.ActivityBindingModule
import com.trial.trialproject.di.module.NetworkModule
import com.trial.trialproject.di.module.RepositoryModule
import com.trial.trialproject.di.module.ViewModelFactoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class,
        NetworkModule::class]
)
interface BaseComponent : AndroidInjector<DaggerApplication> {

}