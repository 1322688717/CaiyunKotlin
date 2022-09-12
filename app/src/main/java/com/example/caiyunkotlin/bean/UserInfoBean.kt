package com.example.caiyunkotlin.bean

import android.graphics.Picture
import android.provider.ContactsContract

data class UserInfoBean(
    var username : String,
    var nickname: String,
    var sex : String,
    var location : String,
    var indexSign : String,
    var headPicture : String,
    )