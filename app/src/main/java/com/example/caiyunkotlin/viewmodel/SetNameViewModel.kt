package com.example.caiyunkotlin.viewmodel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SetNameViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var isComplete = MutableLiveData<Boolean>()

    init {
        isComplete.value = false
    }

    fun getName(activity : Activity){

        val sharedPreferences: SharedPreferences = activity.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        var mName = sharedPreferences.getString("name", "中国青年")
        name.value = mName!!
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