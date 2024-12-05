package com.example.stickerly.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.Model.CategoryModel
import com.example.stickerly.databinding.ViewholderSearchTrendingBinding

class SearchTrendingAdapter(private val items:List<CategoryModel>):RecyclerView.Adapter<SearchTrendingAdapter.Viewholder>() {
    class Viewholder(val binding: ViewholderSearchTrendingBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchTrendingAdapter.Viewholder {
        val binding=ViewholderSearchTrendingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: SearchTrendingAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.txtTrendingSearches.text=item.Name

        Glide.with(holder.itemView.context)
            .load(item.Picture)
            .into(holder.binding.imageTrendingSearch)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}