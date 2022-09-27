package com.example.caiyunkotlin.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.databinding.ActivityPersonalCenterBinding
import com.example.caiyunkotlin.utlis.RouterUtil
import com.example.caiyunkotlin.viewmodel.PersonalCenterViewModel

class PersonalCenterActivity : BaseActivity() {

    lateinit var binding: ActivityPersonalCenterBinding
    lateinit var viewModel: PersonalCenterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PersonalCenterViewModel::class.java)

        initView()
        initOnclick()
    }

    private fun initOnclick() {
        binding.apply {
            clName.setOnClickListener{
                RouterUtil().goSetNameActivity(this@PersonalCenterActivity)
            }

        }
    }

    private fun initView() {
        viewModel.getUserName()

        viewModel.userName.observe(this){
            binding.tvUserName.text = it
        }

    }
}