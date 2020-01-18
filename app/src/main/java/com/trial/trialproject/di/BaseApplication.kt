package com.trial.trialproject.di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication() : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        val component = DaggerBaseComponent.builder().build()
        component.inject(this)
        return component
    }

}