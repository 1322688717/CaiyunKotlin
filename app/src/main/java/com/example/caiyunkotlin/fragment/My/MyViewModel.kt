package com.example.caiyunkotlin.fragment.My

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.caiyunkotlin.R

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

    fun getNickname() {
    }

    fun getIndSignature(){}

}