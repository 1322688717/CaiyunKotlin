package com.example.caiyunkotlin.bean

data class BeanNowWeather(
    val results: List<Result>
)

data class Result(
    val last_update: String,
    val location: Location,
    val now: Now
)

data class Location(
    val country: String,
    val id: String,
    val name: String,
    val path: String,
    val timezone: String,
    val timezone_offset: String
)

data class Now(
    val code: String,
    val temperature: String,
    val text: String
)