package com.example.caiyunkotlin.activity

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.databinding.ActivitySetNameBinding
import com.example.caiyunkotlin.viewmodel.SetNameViewModel
import kotlinx.android.synthetic.main.activity_set_name.*
import kotlinx.android.synthetic.main.activity_set_name.view.*


class SetNameActivity : BaseActivity() {

    lateinit var binding: ActivitySetNameBinding
    lateinit var viewModel : SetNameViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(SetNameViewModel::class.java)

        initView()
        initOnclick()
    }


    /**
     * 所有控件点击监听
     */
    private fun initOnclick() {
        binding.apply {
            img_delete.setOnClickListener {
                binding.editName.setText("")
            }

            imgBack.setOnClickListener {
                finish()
            }

            btnComplete.setOnClickListener {
                var name = binding.editName.text.toString()
                viewModel.setName(this@SetNameActivity,name)
            }
        }
    }

    /**
     * 初始化所有ui数据
     */
    private fun initView() {
        viewModel.getName(this)
        viewModel.name.observe(this){
            binding.editName.setText(it)
            initEdit(it)

        }
    }


    /**
     * 监听edittext
     */
    private fun initEdit(it : String) {
        binding.editName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            @RequiresApi(Build.VERSION_CODES.M)
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == it){
                    binding.btnComplete.isClickable = false
                    binding.btnComplete.setBackgroundResource(R.drawable.btn_bg_gry)
                    binding.btnComplete.btn_complete.setTextColor(getColor(R.color.color_8C8C8C))
                }else{
                    binding.btnComplete.isClickable = true
                    binding.btnComplete.setBackgroundResource(R.drawable.btn_bg_green)
                    binding.btnComplete.btn_complete.setTextColor(getColor(R.color.white))
                }
            }
        })
    }



}