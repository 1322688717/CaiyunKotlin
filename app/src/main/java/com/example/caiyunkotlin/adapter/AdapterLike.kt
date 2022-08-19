package com.example.caiyunkotlin.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.caiyunkotlin.R
import kotlinx.android.synthetic.main.item_like.view.*

class AdapterLike (private var like_url: String) : RecyclerView.Adapter<AdapterLike.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_like,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
        Glide.with(holder.itemView.img_picture)
            .load(like_url)
            .into(holder.itemView.img_picture)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_picture : ImageView = itemView.findViewById(R.id.img_picture)
    }
}