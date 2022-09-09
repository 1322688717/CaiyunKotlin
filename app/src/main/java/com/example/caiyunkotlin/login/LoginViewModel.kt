package com.example.caiyunkotlin.login

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyunkotlin.api.RequestResponse
import com.example.caiyunkotlin.bean.BeanCode
import com.example.caiyunkotlin.bean.BeanLogin
import com.example.caiyunkotlin.bean.UserInfoBean
import com.example.caiyunkotlin.utlis.RouterUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LoginViewModel : ViewModel() {

    var userInfo = MutableLiveData<UserInfoBean>()
    var loginResult = MutableLiveData<LoginRespones>()
    var VerCode = MutableLiveData<String>()      //验证码
    var uuid = MutableLiveData<String>()
    var isclick = MutableLiveData<Boolean>()


    /**
     * 登录
     */
    fun login(account : String , password : String,activity: Activity,code: String,uuid: String){

        RequestResponse.huaoService.getLogin(code,password,account,uuid).enqueue(object : Callback<BeanLogin>{
            override fun onResponse(call: Call<BeanLogin>, response: Response<BeanLogin>) {
                Log.e("TAG","response====${response}")
                Log.e("TAG","token==${response.body()!!.token}")

                RouterUtil().goMainActivity(activity)
                activity.finish()
                if (response.body()!!.code==200){
                    Toast.makeText(activity,"登录成功",Toast.LENGTH_SHORT).show()
                }else if(response.body()!!.code==500){
                    Toast.makeText(activity,"验证码错误",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(activity,"用户名或密码错误",Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<BeanLogin>, t: Throwable) {
                Toast.makeText(activity,"无法连接互联网",Toast.LENGTH_SHORT).show()
            }
        })

    }


    /**
     * 设置登录按钮
     */
    fun setIsClick(account : String , password : String ,code: String){
        if (isUserName(account)){
            if (isPassword(password)){
                isclick.value = isCode(code)
            }else{
                isclick.value = false
            }
        }else{
            isclick.value = false
        }
    }

    fun getIsClick() : LiveData<Boolean>{
        return isclick
    }

    /**
     * 判断是否是账号
     */
    fun isUserName(account: String) : Boolean{
        return account.isNotEmpty()
    }

    /**
     * 判断是否是密码
     */
    fun isPassword(password: String) : Boolean{
        return password.length > 5
    }

    /**
     * 判断是否有验证码
     */
    fun isCode(code: String) : Boolean{
        return code.isNotEmpty()
    }

    /**
     * 获取验证码
     */
    fun getCode(){
        RequestResponse.huaoService.getCode().enqueue(object : Callback<BeanCode>{
            override fun onResponse(call: Call<BeanCode>, response: Response<BeanCode>) {
                Log.e("TAG","uuid=====${response.body()!!.uuid}")
                VerCode.value = response.body()!!.img
                uuid.value = response.body()!!.uuid
            }

            override fun onFailure(call: Call<BeanCode>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}