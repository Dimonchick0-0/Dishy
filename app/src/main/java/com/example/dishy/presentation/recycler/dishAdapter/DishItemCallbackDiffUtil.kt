package com.example.dishy.presentation.recycler.dishAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.Dish

class DishItemCallbackDiffUtil: DiffUtil.ItemCallback<Dish>() {
    override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem == newItem
    }
}