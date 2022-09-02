package com.example.common_lib.statusbar

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.common_lib.R
import com.gyf.immersionbar.ImmersionBar

object StatusBarUtil {

/**
 * 沉浸式状态栏
 */
    fun initStatusBar(activity: Activity) {

    ImmersionBar.with(activity)
        .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
        .init()

    }


}