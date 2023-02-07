package com.example.quoteapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapi.model.ApiResponseItem
import com.example.quoteapi.repository.MainRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val data = MutableLiveData<List<ApiResponseItem>>()
    val mainRepository: MainRepository = MainRepository()

    fun getData() {
        viewModelScope.launch {
            mainRepository.getQuotesFromServer().catch {
                Log.e("API", "get: ${it.localizedMessage}")
            }.collect { list ->
                data.value = list
            }
        }
    }
}