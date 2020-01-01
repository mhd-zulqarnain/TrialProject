package com.trial.trialproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.trial.trialproject.R
import com.trial.trialproject.data.local.Country
import com.trial.trialproject.databinding.SingleMainViewHolderBinding

class MainRecyclerViewAdapter(val dataList: ArrayList<Country>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val binding: SingleMainViewHolderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.single_main_view_holder, parent, false
        )
        return MainViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindView(dataList[position])

    }

    class MainViewHolder(itemView: SingleMainViewHolderBinding) :
        RecyclerView.ViewHolder(itemView.root) {

         var bindingView: SingleMainViewHolderBinding

        init {

            bindingView = itemView
        }
        fun bindView(country: Country) {
            bindingView.countries = country
        }

    }
}