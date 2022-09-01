package com.example.caiyunkotlin.api

import com.example.caiyunkotlin.bean.BeanForecastWeather
import com.example.caiyunkotlin.bean.BeanNowWeather
import com.example.caiyunkotlin.bean.ErathyBean
import com.example.caiyunkotlin.bean.SaoBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

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
}