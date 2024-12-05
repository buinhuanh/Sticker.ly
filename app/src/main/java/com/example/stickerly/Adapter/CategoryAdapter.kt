package com.example.stickerly.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.Model.CategoryModel
import com.example.stickerly.databinding.ViewholderCategoryBinding

class CategoryAdapter(val items:List<CategoryModel>):RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    class Viewholder(val binding:ViewholderCategoryBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Viewholder {
        val binding=ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.titleTxt.text=item.Name

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

