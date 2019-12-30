package com.trial.trialproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.trial.trialproject.R
import com.trial.trialproject.data.Employee
import com.trial.trialproject.retrofit.ApiClient
import com.trial.trialproject.retrofit.TrailServices
import dagger.android.DaggerActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

const val TAG = "MainActivity"

class MainActivity : DaggerActivity() {
    @Inject
    lateinit var mService:TrailServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService.getEmployee()
            .enqueue(object : Callback<List<Employee>> {
                override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                    Log.d(TAG, "failure")
                }

                override fun onResponse(
                    call: Call<List<Employee>>,
                    response: Response<List<Employee>>
                ) {
                    Log.d(TAG, "success${response}")

                }

            })
    }
}
