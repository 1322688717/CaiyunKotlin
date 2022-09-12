package com.example.caiyunkotlin.api

import com.example.caiyunkotlin.bean.*
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

    @FormUrlEncoded()
    @POST("/prod-api/login")
    fun getLogin(@Field("code") code : String, @Field("password") password : String, @Field("username") username : String, @Field("uuid") uuid : String  ) : Call<BeanLogin>
}