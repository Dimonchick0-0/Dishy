package com.example.dishy.presentation.recycler.basketadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dishy.R
import com.example.dishy.databinding.DishBasketItemBinding
import com.example.dishy.domain.entity.Dish

class DishBasketAdapter: ListAdapter<Dish, DishBasketAdapter.DishBasketViewHolder>
    (DishBasketItemCallbackDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishBasketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.dish_basket_item,
            parent,
            false
        )
        return DishBasketViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishBasketViewHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
    }

    class DishBasketViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = DishBasketItemBinding.bind(item)
        fun setData(dish: Dish) = with(binding) {
            Glide.with(itemView)
                .load(dish.image)
                .into(dishImageBasket)
            tvDishTitleBasket.text = dish.titleDish
            tvDishDescrBasket.text = dish.descriptionDish
        }
    }
}