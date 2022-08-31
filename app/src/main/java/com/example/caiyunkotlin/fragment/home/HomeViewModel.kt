package com.example.caiyunkotlin.fragment.home

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.bean.ErathyBean
import com.example.caiyunkotlin.bean.SaoBean
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

class HomeViewModel : ViewModel() {
    var erathy  = MutableLiveData<String>()
    var sao = MutableLiveData<String>()

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

}