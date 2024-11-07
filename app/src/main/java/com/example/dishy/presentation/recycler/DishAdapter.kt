package com.example.dishy.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dishy.R
import com.example.dishy.databinding.DishItemBinding
import com.example.dishy.domain.entity.Dish
import java.net.URL

class DishAdapter: ListAdapter<Dish, DishAdapter.DishViewHolder>(DishItemCallbackDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.dish_item,
            parent,
            false
        )
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val item = getItem(position)
        holder.setDishItem(item)
    }

    class DishViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DishItemBinding.bind(item)
        fun setDishItem(dish: Dish) = with(binding) {
            Glide.with(itemView)
                .load(dish.image)
                .into(dishImage)
            tvDishTitle.text = dish.titleDish
            tvDishDescr.text = dish.descriptionDish
        }
    }
}