package com.trial.trialproject.architecture

import com.trial.trialproject.data.Employee

interface CountryRepository{
    suspend fun getCountries():List<Employee>

}