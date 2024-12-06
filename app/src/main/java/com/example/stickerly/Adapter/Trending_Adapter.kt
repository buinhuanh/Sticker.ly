package com.example.stickerly.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.Model.CategoryModel
import com.example.stickerly.databinding.ViewholderCategoryBinding
import com.example.stickerly.databinding.ViewholderTrendingBinding

class Trending_Adapter(val items:List<CategoryModel>):RecyclerView.Adapter<Trending_Adapter.Viewholder>() {
    class Viewholder(val binding:ViewholderTrendingBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Trending_Adapter.Viewholder {
        val binding=ViewholderTrendingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Trending_Adapter.Viewholder, position: Int) {
        val item=items[position]

        if (item.Picture.isNullOrEmpty()){
            Log.e("GlideError", "Invalid image URL: ${item.Picture}")
        }else{


        Glide.with(holder.itemView.context)
            .load(item.Picture)
            .into(holder.binding.pic)

    }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

