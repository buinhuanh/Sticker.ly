package com.example.stickerly.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stickerly.Model.StickerModel
import com.example.stickerly.databinding.ViewholderStickerBinding

class StickerAdapter(private var items:List<StickerModel>):RecyclerView.Adapter<StickerAdapter.Viewholder>() {

    class Viewholder (val binding: ViewholderStickerBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerAdapter.Viewholder {
        val binding=ViewholderStickerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: StickerAdapter.Viewholder, position: Int) {
         var item=items[position]
         holder.binding.name.text=item.name
        holder.binding.author.text=item.author
        holder.binding.downloads.text=item.dowloads
        holder.binding.releaseDate.text=item.release_date

        val subStickerAdapter=SubStickerAdapter(item.stickers)

        holder.binding.subViewSticker.layoutManager=LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL
        ,false)
        holder.binding.subViewSticker.adapter=subStickerAdapter

    }

    override fun getItemCount(): Int {
        return items.size
    }
}