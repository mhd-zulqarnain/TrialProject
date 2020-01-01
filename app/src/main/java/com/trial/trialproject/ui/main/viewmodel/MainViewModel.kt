package com.trial.trialproject.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.trial.trialproject.architecture.CountryRepository
import com.trial.trialproject.data.local.Country
import kotlinx.coroutines.*
import javax.inject.Inject

const val TAG = "MainViewModel"

class MainViewModel @Inject constructor(
    var countryRepository: CountryRepository
) : ViewModel() {

    //network check mutabledata
    var _network = MutableLiveData<Boolean>()
    var networkCheckLiveData: LiveData<Boolean> = _network

    //country livedata
    var _countryResponse = MutableLiveData<List<Country>>()
    var liveCountryResponse: LiveData<List<Country>> = _countryResponse

    init {
        initiateNetworkCheck()

    }

    fun getCountries() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                withContext(Dispatchers.IO)
                {
                    val response = countryRepository.getDataFromUrl("localdata_1.json")
                    if (response.body() != null && response.code() == 200) {
                        val tmp =
                            (response.body()!!.get("body") as JsonObject)
                                .getAsJsonArray("countries")
                        val type = object : TypeToken<ArrayList<Country>>() {}.type
                        val list: ArrayList<Country>
                        list = Gson().fromJson(Gson().toJson(tmp), type)
                        if (list.size != 0) {
                            withContext(Dispatchers.Main) {
                                _countryResponse.value = list
                            }
                        }
                    }
                }
            }
        }
    }

    fun getLiveDataResponse(): LiveData<List<Country>> {
        return liveCountryResponse
    }

    //network connection check
    fun initiateNetworkCheck() {
        _network.value = true
    }

    fun setNetworkOffline() {
        _network.value = false
    }

    fun setNetworkOnline() {
        _network.value = true
        getCountries()
    }

    fun networkStatus(): LiveData<Boolean> {
        return networkCheckLiveData
    }

}