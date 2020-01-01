package com.trial.trialproject.retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface TrailServices {
    @GET
    fun getDataFromUrl(@Url url:String): Call<JsonObject>

}