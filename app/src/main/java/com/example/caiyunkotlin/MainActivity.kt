package com.example.caiyunkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.caiyunkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //类型后面加?表示可为空
     private  var  binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //抛出空指针异常
        setContentView(binding!!.root)


         val navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding!!.bottomNavigationView,navController)
    }
}