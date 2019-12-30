package com.trial.trialproject.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trial.trialproject.R
import com.trial.trialproject.data.Employee

class MainRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<Employee>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerViewAdapter.MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(ctx).inflate(
                R.layout.single_main_view_holder,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MainRecyclerViewAdapter.MainViewHolder, position: Int) {
        holder.bindView(dataList[position])

    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(employee: Employee) {

        }

    }
}