package com.example.dishy.presentation.recycler.typedishadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.TypeDish

class TypeDishCallbackDiffUtil: DiffUtil.ItemCallback<TypeDish>() {
    override fun areItemsTheSame(oldItem: TypeDish, newItem: TypeDish): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TypeDish, newItem: TypeDish): Boolean {
        return oldItem == newItem
    }
}