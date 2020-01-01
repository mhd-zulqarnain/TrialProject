package com.trial.trialproject.architecture

import com.google.gson.JsonObject
import retrofit2.Response

interface CountryRepository{
    suspend fun getDataFromUrl(url:String): Response<JsonObject>


}