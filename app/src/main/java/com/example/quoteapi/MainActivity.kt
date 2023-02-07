package com.example.quoteapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapi.adapter.QuoteAdapter
import com.example.quoteapi.databinding.ActivityMainBinding
import com.example.quoteapi.viewmodel.MainViewModel
import com.example.quoteapi.model.ApiResponseItem

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getData()

        mainViewModel.data.observe(this, Observer {list ->
            setAdapter(list)
        })
    }

    private fun setAdapter(list: List<ApiResponseItem>) = binding.rcv.apply {
        adapter = QuoteAdapter(list)
        layoutManager = LinearLayoutManager(this@MainActivity)
        val dividerItemDecoration = DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL)
        addItemDecoration(dividerItemDecoration)
    }
}