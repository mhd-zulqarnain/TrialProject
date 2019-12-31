package com.trial.trialproject.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trial.trialproject.architecture.CountryRepository
import com.trial.trialproject.data.Employee
import com.trial.trialproject.retrofit.TrailServices
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

const val TAG = "MainViewModel"

class MainViewModel @Inject constructor(
    var countryRepository: CountryRepository
) : ViewModel() {

    val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    //network check mutabledata
    var _network = MutableLiveData<Boolean>(false)
    var networkCheckLiveData = MutableLiveData<Boolean>(false)

    //country livedata
    var _countryResponse = MutableLiveData<List<Employee>>()
    var liveCountryResponse: LiveData<List<Employee>> = _countryResponse

    init {
        getCountries()

    }

    fun getCountries() {
        coroutineScope.launch {
            withContext(Dispatchers.IO) {
                val list = countryRepository.getCountries()
                if (list.size != 0) {
                    withContext(Dispatchers.Main) {
                        _countryResponse.value = list
                        Log.d(TAG, "_countryResponse ${list.size}")

                    }
                }
            }
        }
    }

    fun getLiveDataResponse(): LiveData<List<Employee>> {
        return liveCountryResponse
    }


    fun initiateNetorkCheck(){

    }
    fun networkCheck(): LiveData<Boolean> {
        return networkCheckLiveData
    }

    //cancelling jobs onclear of viewmodel
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}