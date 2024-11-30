package com.example.dishy.presentation.recycler.basketadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.Dish

class DishBasketItemCallbackDiffUtil: DiffUtil.ItemCallback<Dish>() {
    override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem == newItem
    }
}