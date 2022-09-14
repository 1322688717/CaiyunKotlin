package com.example.caiyunkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.utlis.RouterUtil


class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPreferences: SharedPreferences = getSharedPreferences("token", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")

        if (token != ""){
            goMain()
        }else {
            RouterUtil().goLoginActivity(this)
            finish()
        }
    }

    private fun goMain() {

        val myThread: Thread = object : Thread() {
            //创建子线程
            override fun run() {
                try {
                    sleep(1000) //使程序休眠一秒
//                    val it = Intent(applicationContext, MainActivity::class.java)
//                    startActivity(it)
                    RouterUtil().goMainActivity(this@SplashActivity)
                    finish() //关闭当前活动
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        myThread.start() //启动线程
    }
}