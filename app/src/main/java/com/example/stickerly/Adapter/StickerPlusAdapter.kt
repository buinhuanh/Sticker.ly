package com.example.stickerly.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.Model.StickerPlusModel
import com.example.stickerly.databinding.ActivityStickerlyPlusBinding
import com.example.stickerly.databinding.ViewholderPlusBinding

class StickerPlusAdapter(private val items:List<StickerPlusModel>):RecyclerView.Adapter<StickerPlusAdapter.Viewholder>() {
    class Viewholder(val binding: ViewholderPlusBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StickerPlusAdapter.Viewholder {
        val binding=ViewholderPlusBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: StickerPlusAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.Name.text=item.Name
        holder.binding.decPlus.text=item.decPlus
         Glide.with(holder.itemView.context)
             .load(item.Picture)
             .into(holder.binding.Picture)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}