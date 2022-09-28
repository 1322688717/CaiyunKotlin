package com.example.caiyunkotlin.adapter

import android.R
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.caiyunkotlin.activity.WallPaperActivity
import com.example.caiyunkotlin.bean.Vertical
import kotlinx.android.synthetic.main.item_like.view.*


class AdapterLike (private var vertical: List<Vertical>,private var activity: FragmentActivity)
    : RecyclerView.Adapter<AdapterLike.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.caiyunkotlin.R.layout.item_like,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.w("TAG","img==${vertical.get(0).img}")

        val options = RequestOptions.bitmapTransform(RoundedCorners(50)) //图片圆角为30
        Glide.with(activity)
            .load(vertical[position].img)
            .apply(options)
            .into(holder.itemView.img_picture)

        holder.itemView.img_picture.setOnClickListener {
         val intent = Intent(activity,WallPaperActivity::class.java)
            intent.putExtra("img",vertical[position].img)
            activity.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return vertical.size
    }


}