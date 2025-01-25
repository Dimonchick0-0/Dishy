package com.example.dishy.presentation.recycler.specificalTypeDish

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.Dish

class SpecificTypeDishCallbackDiffUtil: DiffUtil.ItemCallback<Dish>() {
    override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem == newItem
    }
}