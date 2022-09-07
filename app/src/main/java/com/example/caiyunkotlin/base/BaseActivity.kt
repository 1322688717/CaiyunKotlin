package com.example.caiyunkotlin.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caiyunkotlin.R
import com.example.common_lib.statusbar.StatusBarUtil

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        StatusBarUtil.initStatusBar(this)
    }
}