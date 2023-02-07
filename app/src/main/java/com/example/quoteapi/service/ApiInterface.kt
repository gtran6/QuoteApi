package com.example.quoteapi.service

import com.example.quoteapi.model.ApiResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/quotes")
    suspend fun getQuotesList(): ApiResponse
}