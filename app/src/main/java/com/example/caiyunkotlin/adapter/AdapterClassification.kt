package com.example.caiyunkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterClassification : RecyclerView.Adapter<AdapterClassification.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClassification.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.caiyunkotlin.R.layout.item_classification,parent,false)
        return AdapterClassification.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}