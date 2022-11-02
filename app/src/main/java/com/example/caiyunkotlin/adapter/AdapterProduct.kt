package com.example.caiyunkotlin.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.activity.WallPaperActivity
import com.example.caiyunkotlin.utlis.RouterUtil
import kotlinx.android.synthetic.main.item_like.view.*
import kotlinx.android.synthetic.main.item_product.view.*

class AdapterProduct (var activity: Activity): RecyclerView.Adapter<AdapterProduct.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.caiyunkotlin.R.layout.item_product,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val options = RequestOptions.bitmapTransform(RoundedCorners(50)) //图片圆角为30
        Glide.with(activity)
            .load(activity.getDrawable(R.mipmap.head_picture))
            .apply(options)
            .into(holder.itemView.img_item_Product)

        holder.itemView.cl_product.setOnClickListener {
            RouterUtil().goShopInformationActivity(activity)
        }

    }

    override fun getItemCount(): Int {
        return 10
    }

}