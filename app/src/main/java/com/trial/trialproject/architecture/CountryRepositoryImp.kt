package com.trial.trialproject.architecture

import com.trial.trialproject.data.Employee
import com.trial.trialproject.retrofit.TrailServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryRepositoryImp(var mService: TrailServices) : CountryRepository {
    override suspend fun getCountries(): List<Employee> {
        return withContext(Dispatchers.IO) {
            mService.getCountries()
        }
    }

}