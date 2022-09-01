package com.example.caiyunkotlin.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.bean.BeanForecastWeather

class AdapterForcastWeather(var beanForecastWeather: BeanForecastWeather) : RecyclerView.Adapter<AdapterForcastWeather.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_date : TextView? = null
        var tv_temp_top : TextView? = null
        var tv_weather : TextView? = null
        var tv_temp_bottom : TextView? = null
        init {
            tv_date = itemView.findViewById(R.id.tv_date)
            tv_temp_top = itemView.findViewById(R.id.tv_temp_top)
            tv_weather = itemView.findViewById(R.id.tv_weather)
            tv_temp_bottom = itemView.findViewById(R.id.tv_temp_bottom)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterForcastWeather.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_forcast_weather, parent, false)
        return MyViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdapterForcastWeather.MyViewHolder, position: Int) {
        holder.tv_weather!!.text = beanForecastWeather.results[0].daily.get(position).text_day

        holder.tv_temp_top!!.text = "${beanForecastWeather.results[0].daily.get(position).high}/"
        holder.tv_temp_bottom!!.text = beanForecastWeather.results[0].daily.get(position).low
        if (position == 0){
            holder.tv_date!!.text = beanForecastWeather.results[0].daily.get(position).date.substring(5)+"今天"
        }else if (position == 1){
            holder.tv_date!!.text = beanForecastWeather.results[0].daily.get(position).date.substring(5)+"明天"
        }else{
            holder.tv_date!!.text = beanForecastWeather.results[0].daily.get(position).date.substring(5)+"后天"
        }

    }

    override fun getItemCount(): Int {
        return beanForecastWeather.results[0].daily.size
    }
}