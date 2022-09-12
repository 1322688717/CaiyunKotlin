package com.example.caiyunkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.utlis.RouterUtil

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences: SharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        var mName = sharedPreferences.getString("FirstLogin", "0")
        var FirstLogin = mName

        if (FirstLogin == "1"){
            RouterUtil().goMainActivity(this)
            finish()
        }else if (FirstLogin == "0"){
            RouterUtil().goLoginActivity(this)
            finish()
        }
    }
}