package com.example.caiyunkotlin.viewmodel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.bean.Userinfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    /**
     * h获取用户名
     */
    fun getUserName(){
        RequestResponse.huaoService.getUserInfo().enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                userName.value =  response.body()!!.data.nickName
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getSex(){
        RequestResponse.huaoService.getUserInfo().enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                if (response.body()!!.data.sex== "1"){
                    sex.value = "男"
                }else{
                    sex.value = "女"
                }

            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    fun setSex(){

    }

    fun setLocation(){

    }

    fun setpersionSignature(){

    }



}