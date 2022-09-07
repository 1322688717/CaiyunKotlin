package com.example.caiyunkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caiyunkotlin.utlis.RouterUtil

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences: SharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        var mName = sharedPreferences.getString("FirstLogin", "1")
        var FirstLogin = mName

        if (FirstLogin == "1"){
            RouterUtil().goMainActivity(this)
        }else if (FirstLogin == "0"){
            RouterUtil().goLoginActivity(this)
        }
    }
}