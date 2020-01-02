package com.trial.trialproject.di.module

import com.trial.trialproject.services.TrailServices
import com.trial.trialproject.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRefrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Singleton
    @Provides
    fun provideService(mRetrofit: Retrofit):TrailServices{
        return mRetrofit.create(TrailServices::class.java)
    }

}