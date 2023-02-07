package com.example.quoteapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapi.databinding.ItemQuoteBinding
import com.example.quoteapi.model.ApiResponseItem

class QuoteAdapter (val list: List<ApiResponseItem>) : RecyclerView.Adapter<QuoteAdapter.ListViewHolder>() {

    class ListViewHolder (var binding: ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.binding.apply {
            author.text = list[position].a
            quote.text = list[position].q
            numQuote.text = list[position].c
            detail.text = list[position].h
        }
    }
}