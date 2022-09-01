package com.example.caiyunkotlin.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.bean.BeanForecastWeather
import com.example.caiyunkotlin.bean.BeanNowWeather
import com.example.caiyunkotlin.bean.ErathyBean
import com.example.caiyunkotlin.bean.SaoBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel() {
    var erathy  = MutableLiveData<String>()
    var sao = MutableLiveData<String>()
    var city = MutableLiveData<String>()
    var temp = MutableLiveData<String>()
    var state = MutableLiveData<String>()

    var forcastWeather = MutableLiveData<BeanForecastWeather>()


    init {
        erathy.value = "土味情话"
    }

    fun setSao(){
        RequestResponse.UomgService.getErathy("json").enqueue(object : Callback<ErathyBean>{
            override fun onResponse(call: Call<ErathyBean>, response: Response<ErathyBean>) {
                erathy.value = response.body()?.content
            }

            override fun onFailure(call: Call<ErathyBean>, t: Throwable) {
                erathy.value = "网络请求错误"
            }
        })
    }

    fun setErathy(){
        RequestResponse.vvhService.getSao("json").enqueue(object : Callback<SaoBean>{
            override fun onResponse(call: Call<SaoBean>, response: Response<SaoBean>) {
                sao.value = response.body()?.ishan
            }

            override fun onFailure(call: Call<SaoBean>, t: Throwable) {
                erathy.value = "网络请求错误"
            }
        })
    }

    fun setNowWeather(){
        RequestResponse.weatherService.getNowWeather("wuhan").enqueue(object : Callback<BeanNowWeather>{
            override fun onResponse(
                call: Call<BeanNowWeather>,
                response: Response<BeanNowWeather>
            ) {
                city.value = response.body()!!.results.get(0).location.name
                temp.value = response.body()!!.results.get(0).now.temperature
                state.value = response.body()!!.results.get(0).now.text
            }
            override fun onFailure(call: Call<BeanNowWeather>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun setForCastWeather(){
        RequestResponse.weatherService.getForecastWeather("wuhan").enqueue(object  : Callback<BeanForecastWeather>{
            override fun onResponse(
                call: Call<BeanForecastWeather>,
                response: Response<BeanForecastWeather>
            ) {
                forcastWeather.value = response.body()
            }

            override fun onFailure(call: Call<BeanForecastWeather>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}