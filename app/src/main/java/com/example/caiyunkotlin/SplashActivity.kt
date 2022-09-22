package com.example.caiyunkotlin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.bean.Userinfo
import com.example.caiyunkotlin.utlis.RouterUtil
import com.example.common_lib.okhttp.IGetDataListener
import com.example.caiyunkotlin.http.OKHttp
import com.google.gson.Gson
import org.json.JSONObject


class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPreferences: SharedPreferences = getSharedPreferences("token", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")


//        RequestResponse.huaoService.getUserInfo().enqueue(object : Callback<Userinfo>{
//            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
//                Log.e("TAG","response===$response")
//                Log.e("TAG","response.body()===${response.body()}")
//                Log.e("TAG","nickname===${response.body()!!.code}")
//                Log.e("TAG","nickname===${response.body()!!.msg}")
//                Log.e("TAG","nickname===${response.body()!!.data}")
//
//                if (response.body()!!.code == 200){
//                    RouterUtil().goMainActivity(this@SplashActivity)
//                    finish() //关闭当前活动
//                }else{
//                    RouterUtil().goLoginActivity(this@SplashActivity)
//                    finish()
//                }
//            }
//
//            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
//                RouterUtil().goLoginActivity(this@SplashActivity)
//                finish()
//            }
//        })

        OKHttp().getHead(object : IGetDataListener<String>{
            override fun onFailure(reasonOBJ: Any) {
                RouterUtil().goLoginActivity(this@SplashActivity)
                finish()
            }

            override fun onSuccess(dataobj: String) {
//                Log.e("TAG", "dataobj===$dataobj")
//                var userinfo : Userinfo = Gson().fromJson(dataobj,Userinfo::class.java)
//                Log.e("TAG", "userinfo.postGroup===${userinfo}")
//                RouterUtil().goMainActivity(this@SplashActivity)
//                    finish() //关闭当前活动
                RouterUtil().goLoginActivity(this@SplashActivity)
                finish()

            }
        },this)
    }
}