package com.trial.trialproject.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.trial.trialproject.R
import com.trial.trialproject.di.utils.ViewModelFactory
import com.trial.trialproject.services.TrailServices
import com.trial.trialproject.ui.main.viewmodel.MainViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.trial.trialproject.data.local.Country
import com.trial.trialproject.ui.main.adapter.MainRecyclerViewAdapter
import com.trial.trialproject.utils.Utils
import com.trial.trialproject.utils.Utils.showToast
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mService: TrailServices
    private lateinit var vm: MainViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var adapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {

        //viewmodel initiate
        initiateViewModel()

        val list = ArrayList<Country>()
        adapter = MainRecyclerViewAdapter(list)
        rvCountries.adapter = adapter

        //checking device is tablet or mobile
        initDeviceConfiguration()

        //checking network availability
        checkNetworkAavailability()

        //progress visibility
        progressBarvisiblity()

        //observing livedata changes
        vm.getLiveDataResponse().observe(this@MainActivity, Observer {
            if (it.size != 0) {
                list.clear()     //on rotation clearing the previous data
                list.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

    }

    private fun initDeviceConfiguration(){
        if (Utils.isTablet(this@MainActivity)) {
            rvCountries.layoutManager = GridLayoutManager(this@MainActivity, 2)
        } else {
            rvCountries.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initiateViewModel() {
        vm = ViewModelProviders.of(this@MainActivity, viewModelFactory)
            .get(MainViewModel::class.java)
    }

    private fun checkNetworkAavailability() {

        if (Utils.isNetworkAvailable(this@MainActivity))
            vm.setNetworkOnline()
        else{
            vm.setNetworkOffline()
            vm.setProgressBarGone()
        }

        vm.networkStatus().observe(this@MainActivity, Observer { isNetworkAvaliable ->
            if (!isNetworkAvaliable) {
                showToast(getString(R.string.network_not_available))
            }
        })
    }

    private fun progressBarvisiblity() {

        vm.progressBarVisiblity().observe(this@MainActivity, Observer { isVisible ->
            if (isVisible) {
                progressBar.visibility = View.VISIBLE
            }else
                progressBar.visibility = View.GONE

        })

    }



}
