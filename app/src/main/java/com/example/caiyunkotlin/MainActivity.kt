package com.example.caiyunkotlin

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.databinding.ActivityMainBinding
import com.example.caiyunkotlin.viewmodel.MainViewModel


class MainActivity : BaseActivity() {

    private val manager: FragmentManager = supportFragmentManager

    //类型后面加?表示可为空
     private  var  binding : ActivityMainBinding? = null
    private lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //抛出空指针异常
        setContentView(binding!!.root)
         val navController : NavController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding!!.bottomNavigationView,navController)

        initView()
    }

    private fun initView() {
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 点击了返回按键
            if (manager.backStackEntryCount != 0) {
                manager.popBackStack()
            } else {
                viewModel.exitApp(2000,this)
            }
            return true // 返回true，防止该事件继续向下传播
        }
        return super.onKeyDown(keyCode, event)
    }
}