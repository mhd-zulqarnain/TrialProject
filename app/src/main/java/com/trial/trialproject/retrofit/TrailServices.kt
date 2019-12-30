package com.trial.trialproject.retrofit

import com.trial.trialproject.data.Employee
import retrofit2.Call
import retrofit2.http.GET



interface TrailServices{
    @GET("employees")
    fun getEmployee(): Call<List<Employee>>

}