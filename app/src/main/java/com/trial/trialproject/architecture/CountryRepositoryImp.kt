package com.trial.trialproject.architecture

import com.google.gson.JsonObject
import com.trial.trialproject.services.TrailServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CountryRepositoryImp(var mService: TrailServices) : CountryRepository {
    override suspend fun getDataFromUrl(url: String): Response<JsonObject> {
        return withContext(Dispatchers.IO) {
            mService.getDataFromUrl(url).execute()
        }
    }
}