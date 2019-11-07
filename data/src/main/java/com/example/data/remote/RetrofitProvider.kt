package com.example.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitProvider {
    private const val BASE_URL = "http://openapi.open-platform.or.kr/"
    var api: API

    init {
        val retrofit = initRetrofit()
        api = retrofit.create()
    }

    fun initRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}