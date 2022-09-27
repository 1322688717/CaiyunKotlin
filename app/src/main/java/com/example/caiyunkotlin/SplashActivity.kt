package com.example.caiyunkotlin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.bean.Userinfo
import com.example.caiyunkotlin.utlis.RouterUtil
import com.example.common_lib.okhttp.IGetDataListener
import com.example.caiyunkotlin.http.OKHttp
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPreferences: SharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")

        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                if (response.body()!!.data != null){
                    RouterUtil().goMainActivity(this@SplashActivity)
                    finish() //关闭当前活动
                }else{
                    RouterUtil().goLoginActivity(this@SplashActivity)
                    finish()
                }
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                RouterUtil().goMainActivity(this@SplashActivity)
                finish() //关闭当前活动
                Log.e("TAG","t===$t")
            }
        })
    }
}