package com.example.caiyunkotlin.viewmodel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.bean.Userinfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SetNameViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var isComplete = MutableLiveData<Boolean>()

    init {
        isComplete.value = false
    }

    fun getName(activity : Activity){
       val sharedPreferences: SharedPreferences = activity.getSharedPreferences("sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        RequestResponse.huaoService.getUserInfo(token!!).enqueue(object : Callback<Userinfo> {
            override fun onResponse(call: Call<Userinfo>, response: Response<Userinfo>) {
                name.value  =  response.body()!!.data.nickName
            }

            override fun onFailure(call: Call<Userinfo>, t: Throwable) {
                Toast.makeText(activity,t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    fun setName(activity : Activity,name : String){

        //sp为新建xml文件的文件名，MODE模式，PRIVATE私有
        val sharedPreferences: SharedPreferences = activity.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.commit()
        activity.finish()
    }

    fun setIsComplete(){
       // if (name)
    }
}