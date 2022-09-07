package com.example.caiyunkotlin.utlis

import android.content.Context
import android.content.Intent
import com.example.caiyunkotlin.MainActivity
import com.example.caiyunkotlin.activity.PersonalCenterActivity
import com.example.caiyunkotlin.activity.SetNameActivity
import com.example.caiyunkotlin.activity.WallPaperActivity
import com.example.caiyunkotlin.login.LoginActivity

class RouterUtil {


    fun goPersonalCenterActivity(mContext: Context){
        var intent  = Intent(mContext, PersonalCenterActivity::class.java)
        mContext.startActivity(intent)
    }

    fun goWallPaperActivity(mContext: Context){
        var intent  = Intent(mContext, WallPaperActivity::class.java)
        mContext.startActivity(intent)
    }

    fun goSetNameActivity(mContext: Context){
        var intent  = Intent(mContext, SetNameActivity::class.java)
        mContext.startActivity(intent)
    }

    fun goMainActivity(mContext: Context){
        var intent  = Intent(mContext, MainActivity::class.java)
        mContext.startActivity(intent)
    }

    fun goLoginActivity(mContext: Context){
        var intent  = Intent(mContext, LoginActivity::class.java)
        mContext.startActivity(intent)
    }

}