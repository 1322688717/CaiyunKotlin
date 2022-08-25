package com.example.caiyunkotlin.fragment.like

import android.app.Activity
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.example.caiyunkotlin.adapter.AdapterLike
import com.example.caiyunkotlin.bean.BeanLike
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

class LikeViewModel : ViewModel() {
    var likeBean = MutableLiveData<BeanLike>()

    init {

    }

        fun getLikeBean(url : String,activity: Activity) {
        val request = Request.Builder().url(url!!).build()
        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "e$e")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("tag","response===${response}")
                val jsonobj   = JSONObject(response.body!!.string())

                //这里是利用gson解析
                val json = Gson().fromJson(jsonobj.toString(), BeanLike::class.java)
                activity.runOnUiThread {
                    likeBean.value = json
                }

                //这里是直接拿json对象一层一层拿自己想要的
//                val res : JSONObject? = jsonobj.optJSONObject("res")
//                val vertical : JSONArray? = res?.optJSONArray("vertical")
//                val itemObj : JSONObject = vertical!!.optJSONObject(0)
//                val img : String = itemObj.optString("img")
//                Log.e("tag","img==$img")
//                activity!!.runOnUiThread {
//                    binding!!.rcWallpaper.layoutManager = GridLayoutManager(activity,2)
//                    adapter = AdapterLike(json.res.vertical,activity!!)
//                    binding!!.rcWallpaper.adapter = adapter




            }
        })
    }

    fun setLikeBean(){

    }

    override fun onCleared() {
        super.onCleared()
    }
}