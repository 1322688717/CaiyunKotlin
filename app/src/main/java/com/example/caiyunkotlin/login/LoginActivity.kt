package com.example.caiyunkotlin.login

import android.annotation.SuppressLint
import android.icu.lang.UScript.getCode
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.base.BaseActivity
import com.example.caiyunkotlin.databinding.ActivityLoginBinding
import com.example.caiyunkotlin.utlis.RouterUtil
import com.example.caiyunkotlin.utlis.UtliBase64
import kotlinx.android.synthetic.main.activity_login.*
import java.nio.Buffer

class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel : LoginViewModel
    var account:String = ""
    var passWord:String = ""
    var code : String = ""
    var uuid : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        initView()
        initOnclick()
        getCode()  //获取验证码
        initEdit()



    }



    /**
     * //监听账号密码
     */
    @SuppressLint("ResourceAsColor")
    private fun initEdit() {
        binding.edtAccount.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == ""){
                    binding.imgDeleteAccount.visibility = View.GONE
                }else{
                    binding.imgDeleteAccount.visibility =View.VISIBLE
                }
            }
        })

        binding.edtPassword.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.isPassword(s.toString())
                if (s.toString() == ""){
                    binding.imgDeletePassword.visibility = View.GONE
                }else{
                    binding.imgDeletePassword.visibility =View.VISIBLE
                }
            }
        })

        binding.edtVerCode.addTextChangedListener {
            viewModel.isCode(it.toString())

            if (viewModel.isUserName(it.toString())){
                binding.btnLogin.isClickable = true
                binding.btnLogin.setBackgroundResource(R.drawable.btn_bg_green)
                binding.btnLogin.setTextColor(R.color.white)
            }else{
                binding.btnLogin.isClickable = false
                binding.btnLogin.setBackgroundResource(R.drawable.btn_bg_gry)
                binding.btnLogin.setTextColor(R.color.color_8C8C8C)
            }
        }

    }

    /**
     * 获取验证码
     */
    private fun getCode() {
        viewModel.getCode()

        viewModel.VerCode.observe(this) {
            binding.imgCode
            Glide.with(this)
                .load(UtliBase64().stringToBitmap("data:image/gif;base64,$it"))
                .into(binding.imgCode)
        }
    }

    /**
     * 所有点击事件处理
     */
    private fun initOnclick() {
        binding.apply {

            //点击登录
            btnLogin.setOnClickListener {
                account = edtAccount.text.toString()
                passWord = edtPassword.text.toString()
                code = edtVerCode.text.toString()
                Log.e("TAG","account====${account}")
                Log.e("TAG","password====${passWord}")
                Log.e("TAG","code====${code}")
                Log.e("TAG","uuid====${uuid}")
                viewModel.login(account, passWord,this@LoginActivity, code, uuid)
                RouterUtil().goMainActivity(this@LoginActivity)
                this@LoginActivity.finish()
            }

            imgDeleteAccount.setOnClickListener {
                binding.edtAccount.setText("")
            }

            imgDeletePassword.setOnClickListener {
                binding.edtPassword.setText("")
            }

            imgCode.setOnClickListener {
                viewModel.getCode()

            }
        }
    }


    private fun initView() {
      viewModel.uuid.observe(this){
          this.uuid = it
      }
    }
}