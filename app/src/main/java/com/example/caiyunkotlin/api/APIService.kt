package com.example.caiyunkotlin.api

import com.example.caiyunkotlin.bean.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface APIService {
    @GET("/api/sao")
    fun getSao(@Query("type") type : String) : Call<SaoBean>

    @GET("/api/rand.qinghua")
    fun getErathy(@Query("format") format : String) : Call<ErathyBean>

    @GET("/v3/weather/now.json?key=SRSE70OFAul-Ppk2W")
    fun getNowWeather(@Query("location") location : String ) : Call<BeanNowWeather>

    @GET("/v3/weather/daily.json?key=SRSE70OFAul-Ppk2W")
    fun getForecastWeather(@Query("location") location : String ) : Call<BeanForecastWeather>

    @GET("/v3/life/suggestion.json?key=SRSE70OFAul-Ppk2W")
    fun getLifeIndex(@Query("location") location : String ) : Call<BeanForecastWeather>

    @GET("/prod-api/captchaImage")
    fun getCode() : Call<BeanCode>

    /**
     * 这里是以表单形式post请求
     */
//    @FormUrlEncoded()
//    @POST("/prod-api/login")
//    fun getLogin(@Field("code") code : String, @Field("password") password : String, @Field("username") username : String, @Field("uuid") uuid : String  ) : Call<BeanLogin>

    /**
     * 这里是以json形式请求
     */
    @POST("/prod-api/login")
    fun getLogin(@Body body: BeanGologin): Call<BeanLogin>

    @GET("/prod-api/system/user/profile")
    fun getUserInfo(@Query("Authorization") Authorization : String) : Call<SaoBean>
}