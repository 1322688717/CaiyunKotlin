package com.example.caiyunkotlin.api

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
}