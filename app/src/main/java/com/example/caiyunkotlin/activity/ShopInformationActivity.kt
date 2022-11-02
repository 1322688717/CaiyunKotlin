package com.example.caiyunkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.databinding.ActivityShopInformationBinding
import com.example.caiyunkotlin.viewmodel.ShopInformationViewModel
import kotlinx.android.synthetic.main.activity_login.*

class ShopInformationActivity : BaseActivity() {

    lateinit var binding : ActivityShopInformationBinding
    lateinit var viewmodel : ShopInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopInformationBinding.inflate(layoutInflater)
        viewmodel = ViewModelProvider(this).get(ShopInformationViewModel::class.java)
        setContentView(binding.root)
    }
}