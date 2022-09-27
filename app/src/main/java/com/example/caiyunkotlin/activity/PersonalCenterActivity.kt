package com.example.caiyunkotlin.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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

            imgExit.setOnClickListener{
                finish()
            }

        }
    }

    private fun initView() {
        viewModel.getUserName(this)
        viewModel.userName.observe(this){
            binding.tvUserName.text = it
        }

        viewModel.getAvatar(this)
        viewModel.avatar.observe(this){
            val opt : RequestOptions = RequestOptions().circleCrop()
            Glide.with(this)
                .load("http://47.98.113.125:8082/$it")
                .apply(opt)
                .into(binding.imgAvatar)
        }

    }
}