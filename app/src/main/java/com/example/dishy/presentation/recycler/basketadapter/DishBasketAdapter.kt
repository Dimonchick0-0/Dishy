package com.example.dishy.presentation.recycler.basketadapter

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

        var onItemDeleteClickListener: ((Dish) -> Unit)? = null

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
        holder.binding.btnDeleteBasket.setOnClickListener {
            onItemDeleteClickListener?.invoke(item)
        }
    }

    class DishBasketViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DishBasketItemBinding.bind(item)
        fun setData(dish: Dish) = with(binding) {
            Glide.with(itemView)
                .load(dish.image)
                .into(dishImageBasket)
            tvDishTitleBasket.text = dish.titleDish
            tvDishDescrBasket.text = dish.descriptionDish
        }
    }

    companion object {
        const val TYPE_VIEW = 1
        const val MAX_VIEW_POOL = 15
    }
}