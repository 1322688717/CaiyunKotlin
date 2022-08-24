package com.example.common_lib.utils

import android.util.Log

class LogUtil {
    fun String.LogD(tag: String? = null) {
        Log.d("TAG",tag!!)
    }
}