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


class MainViewModel @Inject constructor(
    var countryRepository: CountryRepository
) : ViewModel() {

    //network check handling
    private var _network = MutableLiveData<Boolean>()
    private var networkCheckLiveData: LiveData<Boolean> = _network

    //country data livedata handling
    private var _countryResponse = MutableLiveData<List<Country>>()
    private var liveCountryResponse: LiveData<List<Country>> = _countryResponse

    //progress bar handling
    private var _loader = MutableLiveData<Boolean>()
    private var loaderLiveData: LiveData<Boolean> = _loader


    init {
        initiateNetworkCheck()
        initiateProgressBar()
    }


    fun getCountries() {

        /*
        you can only end point of url
        or full url as per requirement base url
        will be ignored if we use fullurl
        */
//        val fullUrl="https://atom-assets.s3.eu-central-1.amazonaws.com/android/3.0.0/localdata_1.json"
        val endPointUrl="localdata_1.json"
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                withContext(Dispatchers.IO)
                {
                    val response = countryRepository.getDataFromUrl(url =endPointUrl)
                    if (response.body() != null && response.code() == 200) {
                        val tmp =
                            (response.body()!!.get("body") as JsonObject)
                                .getAsJsonArray("countries")
                        if (tmp != null) {
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

                    withContext(Dispatchers.Main) {
                        setProgressBarGone()
                    }

                }
            }
        }
    }

    fun getLiveDataResponse(): LiveData<List<Country>> {
        return liveCountryResponse
    }

    //region progressbar

    private fun initiateProgressBar() {
        setProgressBarVisible()
    }

    fun setProgressBarGone() {
        _loader.value = false
    }

    fun setProgressBarVisible() {
        _loader.value = true
    }

    fun progressBarVisiblity(): LiveData<Boolean> {
        return loaderLiveData
    }
    //endregion

    //region network connection check
    private fun initiateNetworkCheck() {
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
    //endregion


}