package com.example.stickerly.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stickerly.Model.SuggestedModel
import com.example.stickerly.databinding.ViewholderSuggestedBinding

class SuggestedAdapter(private val items:List<SuggestedModel>):RecyclerView.Adapter<SuggestedAdapter.Viewholder>() {
    class Viewholder(val binding: ViewholderSuggestedBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestedAdapter.Viewholder {
        val binding=ViewholderSuggestedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: SuggestedAdapter.Viewholder, position: Int) {
          val item=items[position]
        holder.binding.nameSuggested.text=item.nameSuggested
        holder.binding.numberSticker.text=item.numberSuggested

        Glide.with(holder.itemView.context)
            .load(item.imageSuggested)
            .into(holder.binding.imageSuggested)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}