package com.example.dishy.presentation.recycler.typedishadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dishy.R
import com.example.dishy.databinding.TypeDishItemBinding
import com.example.dishy.domain.entity.TypeDish

class TypeDishAdapter: ListAdapter<TypeDish,
        TypeDishAdapter.TypeDishViewHolder>(TypeDishCallbackDiffUtil()) {

    class TypeDishViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = TypeDishItemBinding.bind(view)
        fun setData(typeDish: TypeDish) = with(binding) {
            Glide.with(itemView)
                .load(typeDish.image)
                .into(typeDishImage)
            tvTypeDishTitle.text = typeDish.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeDishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.type_dish_item,
            parent,
            false
        )
        return TypeDishViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypeDishViewHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
    }
}