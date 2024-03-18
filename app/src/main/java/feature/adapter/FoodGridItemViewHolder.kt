package com.catnip.layoutingexample.presentation.foodlist.adapter.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.layoutingexample.layoutingexample.model.Food
import com.catnip.layoutingexample.layoutingexample.presentation.foodlist.adapter.OnItemClickedListener
import com.example.suek.R
import com.example.suek.databinding.ItemFoodGridBinding
import feature.base.ViewHolderBinder

class FoodGridItemViewHolder(
    private val binding: ItemFoodGridBinding,
    private val listener: OnItemClickedListener<Food>
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Food> {

    override fun bind(item: Food) {
        item.let {
            binding.ivFoodPhoto.load(it.pictUrl) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvFoodName.text = it.name
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
            binding.tvFoodPrice.text = it.price
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }

        }
    }
}