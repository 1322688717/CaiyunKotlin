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
    var avatar = MutableLiveData<String>()

    init {
        userName.value = ""
        sex.value = ""
        location.value = " 武汉"
        persionSignature.value = "这个人很懒什么都没留下..."
    }

    /**
     * h获取用户名
     */
    fun getUserName(activity : Activity){
       val sharedPreferences: SharedPreferences = activity.getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                userName.value =  response.body()!!.data.nickName
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    /**
     * 获取性别
     */
    fun getSex(activity : Activity){
       val sharedPreferences: SharedPreferences = activity.getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo>{
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

    /**
     * 获取地址
     */
    fun getLocation(activity : Activity){
       val sharedPreferences: SharedPreferences = activity.getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                location.value =  response.body()!!.data.nickName
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    /**
     * 获取个签
     */
    fun getPersionSignature(activity : Activity){
       val sharedPreferences: SharedPreferences = activity.getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                persionSignature.value =  response.body()!!.data.nickName
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    /**
     * 获取用户头像
     */
    fun getAvatar(activity : Activity){
       val sharedPreferences: SharedPreferences = activity.getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo>{
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                avatar.value =  response.body()!!.data.avatar
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }



}