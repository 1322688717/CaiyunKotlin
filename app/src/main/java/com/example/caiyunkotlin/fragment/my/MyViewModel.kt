package com.example.caiyunkotlin.fragment.my

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var headPortrait = MutableLiveData<String>()
    var nickname =  MutableLiveData<String>()
    var IndSignature = MutableLiveData<String>()  //个性签名

    init {
        nickname.value = "中国青年"
        IndSignature.value = "这个人很懒，什么都没留下..."
    }
    fun setHeadPortrait(mcontext : FragmentActivity) {

    }

    fun getNickname(activity : Activity) {
        val sharedPreferences: SharedPreferences = activity.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        var mName = sharedPreferences.getString("name", "中国青年")
        nickname.value = mName!!
    }

    fun getIndSignature(){}

}