package com.trial.trialproject.retrofit

import com.trial.trialproject.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {


    val mRetrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    companion object {
        var client: ApiClient? = null
        fun getInstnace(): ApiClient? {
            if (client == null) {
                client = ApiClient()
            }
            return client
        }

    }

    fun getServices():TrailServices {
        return mRetrofit.create(TrailServices::class.java)
    }

}