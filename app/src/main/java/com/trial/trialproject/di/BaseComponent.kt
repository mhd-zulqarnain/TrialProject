package com.trial.trialproject.di

import com.trial.trialproject.di.module.ActivityBindingModule
import com.trial.trialproject.di.module.NetworkModule
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
        NetworkModule::class]
)
interface BaseComponent : AndroidInjector<DaggerApplication> {

}