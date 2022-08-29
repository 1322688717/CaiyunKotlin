package com.example.common_lib.okhttp

import android.telecom.Call
import android.util.Log
import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkHttp {
    lateinit var TpyeUrl : String

    fun getUrl(tpye : Int) : String{
        when (tpye){
            1 -> "https://service.picasso.adesk.com/v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot"
            else ->"123"
        }
        return TpyeUrl
    }

    fun getOKHttp(type : Int) : OkHttpClient{
        val request = Request.Builder().url(getUrl(type)).build()
        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build()

        return client

//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Log.d("TAG", "e$e")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                Log.d("tag","response===${response}")
//                val jsonobj   = JSONObject(response.body!!.string())
//
//                //这里是利用gson解析
//                val json = Gson().fromJson(jsonobj.toString(), BeanLike::class.java)
//                activity.runOnUiThread {
//                    likeBean.value = json
//                }
//            }
//        })
    }
}