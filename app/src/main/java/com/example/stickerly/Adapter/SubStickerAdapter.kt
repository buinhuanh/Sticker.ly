package com.example.stickerly.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.databinding.ViewholderSubStickerBinding

class SubStickerAdapter(private var items: List<String>):RecyclerView.Adapter<SubStickerAdapter.Viewholder>() {
    class Viewholder(val binding: ViewholderSubStickerBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubStickerAdapter.Viewholder {
        val binding=ViewholderSubStickerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: SubStickerAdapter.Viewholder, position: Int) {
        val item=items[position]
        Glide.with(holder.itemView.context)
            .load(item)
            .into(holder.binding.subImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}