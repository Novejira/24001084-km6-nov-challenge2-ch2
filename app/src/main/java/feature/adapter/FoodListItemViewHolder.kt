package com.catnip.layoutingexample.presentation.foodlist.adapter.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.layoutingexample.layoutingexample.presentation.foodlist.adapter.OnItemClickedListener
import com.example.suek.R
import com.example.suek.databinding.ItemFoodListBinding
import feature.base.ViewHolderBinder
import feature.model.Catalog

class FoodListItemViewHolder(
    private val binding: ItemFoodListBinding,
    private val listener: OnItemClickedListener<Catalog>
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Catalog> {
    override fun bind(item: Catalog) {
        item.let {
            binding.ivFoodPhoto.load(it.image) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvFoodName.text = it.name
            binding.tvFoodPrice.text = it.formattedPrice
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}