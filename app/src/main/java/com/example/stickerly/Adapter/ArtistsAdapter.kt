package com.example.stickerly.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.Model.ArtistsModel
import com.example.stickerly.databinding.ViewholderArtistsBinding

class ArtistsAdapter(private val items:List<ArtistsModel>):RecyclerView.Adapter<ArtistsAdapter.Viewholder>() {
    class Viewholder(val binding: ViewholderArtistsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsAdapter.Viewholder {
        val binding=ViewholderArtistsBinding.inflate(LayoutInflater.from(parent.context),parent,false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.nameArtists.text=item.nameArtists
        holder.binding.decArtists.text=item.decArtists
        holder.binding.numberArtists.text=item.numberArtists

        Glide.with(holder.itemView.context)
            .load(item.imageArtists)
            .into(holder.binding.imageArtists)

        val subArtistsAdapter=SubArtistsAdapter(item.subArtists)
        holder.binding.viewSubArtists.layoutManager=LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.viewSubArtists.adapter=subArtistsAdapter
    }

    override fun getItemCount(): Int {
        return items.size
    }
}