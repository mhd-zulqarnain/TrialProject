package com.trial.trialproject.di.module

import com.trial.trialproject.architecture.CountryRepository
import com.trial.trialproject.architecture.CountryRepositoryImp
import com.trial.trialproject.retrofit.TrailServices
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCountryRepository(mService: TrailServices): CountryRepository{
        return CountryRepositoryImp(mService)
    }
}