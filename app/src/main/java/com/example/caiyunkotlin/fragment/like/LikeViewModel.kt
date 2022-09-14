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

        fun setLikeBean(url : String,activity: Activity) {
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
                }
            })
    }

    fun getLikeBean(url : String,activity: Activity) {

    }

    override fun onCleared() {
        super.onCleared()
    }
}