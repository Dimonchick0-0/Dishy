package com.example.dishy.presentation.recycler.typedishadapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.domain.entity.TypeDish

class TypeDishCallbackDiffUtil: DiffUtil.ItemCallback<Dishy>() {
    override fun areItemsTheSame(oldItem: Dishy, newItem: Dishy): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Dishy, newItem: Dishy): Boolean {
        return oldItem == newItem
    }
}