package com.trial.trialproject.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.trial.trialproject.R
import com.trial.trialproject.di.utils.ViewModelFactory
import com.trial.trialproject.retrofit.TrailServices
import com.trial.trialproject.ui.main.viewmodel.MainViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.trial.trialproject.data.Employee
import com.trial.trialproject.ui.main.adapter.MainRecyclerViewAdapter
import com.trial.trialproject.utils.Utils
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mService: TrailServices
    lateinit var vm: MainViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {

        //viewmodel initiate
        vm = ViewModelProviders.of(this@MainActivity, viewModelFactory)
            .get(MainViewModel::class.java)

        val list = ArrayList<Employee>()
        val adapter = MainRecyclerViewAdapter(this@MainActivity, list)
        rvCountries.adapter = adapter

        //checking device is tablet or mobile
        if (Utils.isTablet(this@MainActivity)) {
            rvCountries.layoutManager = GridLayoutManager(this@MainActivity, 2)
        } else {
            rvCountries.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        //observing livedata changes
        vm.getLiveDataResponse().observe(this@MainActivity, Observer {
            if (it.size != 0) {
                list.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

    }


}
