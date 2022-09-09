package com.example.common_lib.okhttp

import android.widget.Switch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtlis {
    private var Base_URL = ""

    fun getRetrofit(type: Int) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(getUrl(type))
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }


    /**
     * 调用create方法，传入service接口对应的Class类型，创建一个该接口的动态代理对象
     *
     * 动态代理：有了这个动态代理对象后，我们就可以随意调用接口中定义的所有方法
     */
    fun <T> create(serviceClass: Class<T>,type: Int) : T =  getRetrofit(type).create(serviceClass)

    fun getUrl(type : Int) : String{
        when (type){
            1 -> Base_URL = "https://api.vvhan.com"  //韩小韩API接口站
            2 -> Base_URL = "https://api.uomg.com"  //UomgAPI 接口网站
            3 -> Base_URL = "https://api.seniverse.com/"  //心知天气
            4 -> Base_URL = "http://121.5.233.252"
        }
        return Base_URL
    }
}