package com.example.quoteapi.repository

import com.example.quoteapi.model.ApiResponse
import com.example.quoteapi.service.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepository {

    fun getQuotesFromServer() : Flow<ApiResponse> = flow<ApiResponse> {
        emit(RetrofitInstance.apiRetrofit.getQuotesList())
    }
}