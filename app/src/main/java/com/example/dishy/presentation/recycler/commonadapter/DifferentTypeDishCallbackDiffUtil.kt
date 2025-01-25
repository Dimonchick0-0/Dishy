package com.example.dishy.presentation.recycler.commonadapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.domain.entity.TypeDish

class DifferentTypeDishCallbackDiffUtil: DiffUtil.ItemCallback<TypeDish>() {
    override fun areItemsTheSame(oldItem: TypeDish, newItem: TypeDish): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: TypeDish, newItem: TypeDish): Boolean {
        return oldItem == newItem
    }
}