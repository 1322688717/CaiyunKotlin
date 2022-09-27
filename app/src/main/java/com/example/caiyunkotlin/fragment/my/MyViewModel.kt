package com.example.caiyunkotlin.fragment.my

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.bean.Userinfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        RequestResponse.huaoService.getUserInfo().enqueue(object : Callback<Userinfo> {
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                nickname.value =  response.body()!!.data.nickName
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getIndSignature(){}

}