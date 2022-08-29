package com.example.caiyunkotlin.fragment.home

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.bean.ErathyBean
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

class HomeViewModel : ViewModel() {
    var erathy  = MutableLiveData<String>()

    init {
        erathy.value = "土味情话"
    }

    fun setErathy(url: String,activity: Activity){
        val request = Request.Builder().url(url!!).build()
        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                 var gson  = Gson()
                var jsonstr = JSONObject(response.body!!.string())
                var erathyBean : ErathyBean =  gson.fromJson(jsonstr.toString(),ErathyBean::class.java)
                activity.runOnUiThread(){
                    erathy.value = erathyBean.content
                }
            }

        })
    }

    fun getErathy() {

    }
}