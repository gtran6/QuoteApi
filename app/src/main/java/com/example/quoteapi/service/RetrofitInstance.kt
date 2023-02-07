package com.example.quoteapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://zenquotes.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiRetrofit by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}