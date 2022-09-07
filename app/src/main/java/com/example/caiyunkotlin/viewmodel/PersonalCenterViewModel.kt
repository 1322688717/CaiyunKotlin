package com.example.caiyunkotlin.viewmodel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonalCenterViewModel : ViewModel() {
    var userName = MutableLiveData<String>()
    var sex = MutableLiveData<String>()
    var location = MutableLiveData<String>()
    var persionSignature = MutableLiveData<String>()

    init {
        userName.value = "中国青年"
        sex.value = "男"
        location.value = "湖北 武汉"
        persionSignature.value = "这个人很懒什么都没留下..."
    }

    fun getUserName(activity : Activity){
        val sharedPreferences: SharedPreferences = activity.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        var mName = sharedPreferences.getString("name", "中国青年")
        userName.value = mName!!
    }

    fun setSex(){

    }

    fun setLocation(){

    }

    fun setpersionSignature(){

    }



}