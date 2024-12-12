package com.example.dishy.presentation.recycler.differentAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.DifferentDishes

class DifferentDishCallbackDiffUtil: DiffUtil.ItemCallback<DifferentDishes>(){
    override fun areItemsTheSame(oldItem: DifferentDishes, newItem: DifferentDishes): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DifferentDishes, newItem: DifferentDishes): Boolean {
        return oldItem == newItem
    }
}