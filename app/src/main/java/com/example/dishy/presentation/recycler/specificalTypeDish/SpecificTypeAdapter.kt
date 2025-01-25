package com.example.dishy.presentation.recycler.specificalTypeDish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dishy.R
import com.example.dishy.databinding.SpecificTypeDishItemBinding
import com.example.dishy.domain.entity.Dish

class SpecificTypeAdapter: ListAdapter<Dish, SpecificTypeAdapter.SpecificTypeDishViewHolder>(
    SpecificTypeDishCallbackDiffUtil()
) {

    var addDishToBasketClickListener: ((Dish) -> Unit)? = null

    class SpecificTypeDishViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = SpecificTypeDishItemBinding.bind(item)
        fun setData(dish: Dish) = with(binding) {
            Glide.with(itemView)
                .load(dish.image)
                .into(imgSpecificType)
            titleSpecificType.text = dish.titleDish
            descrSpecificType.text = dish.descriptionDish
            dishPrice.text = String.format("%s", dish.priceDish)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificTypeDishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.specific_type_dish_item,
            parent,
            false
        )
        return SpecificTypeDishViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecificTypeDishViewHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
        holder.binding.btnOrderSpecificType.setOnClickListener {
            addDishToBasketClickListener?.invoke(item)
        }
    }
}