package com.trial.trialproject.di.module
import com.trial.trialproject.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class])
    abstract fun bindMainActivity(): MainActivity

}