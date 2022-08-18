package com.example.caiyunkotlin

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.caiyunkotlin.databinding.ActivityMainBinding
import com.example.common_lib.statusbar.StatusBarUtil

class MainActivity : AppCompatActivity() {

    //类型后面加?表示可为空
     private  var  binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //抛出空指针异常
        setContentView(binding!!.root)
         val navController : NavController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding!!.bottomNavigationView,navController)

        StatusBarUtil.initStatusBar(this)
    }

}