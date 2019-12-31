package com.trial.trialproject.retrofit

import com.trial.trialproject.data.Employee
import com.trial.trialproject.data.remote.BaseModel
import com.trial.trialproject.data.remote.Country
import retrofit2.Call
import retrofit2.http.GET


interface TrailServices {
    @GET("employees")
    fun getEmployee(): Call<List<Employee>>

    @GET("localdata_1.json")
    fun getDataResponse(): BaseModel<Country>

    @GET("employees")
    suspend fun getCountries(): List<Employee>

}