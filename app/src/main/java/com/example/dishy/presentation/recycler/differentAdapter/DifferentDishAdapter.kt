package com.example.dishy.presentation.recycler.differentAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dishy.R
import com.example.dishy.databinding.DifferentDishItemBinding
import com.example.dishy.domain.entity.DifferentDishes

class DifferentDishAdapter: ListAdapter<DifferentDishes,
        DifferentDishAdapter.DifferentDishItemViewHolder>(DifferentDishCallbackDiffUtil()) {

    var onAddItemClickListener: ((DifferentDishes) -> Unit)? = null

    class DifferentDishItemViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DifferentDishItemBinding.bind(item)
        fun setData(differentDishes: DifferentDishes) = with(binding) {
            Glide.with(itemView)
                .load(differentDishes.image)
                .into(differentDishImage)
            tvDifferentDishTitle.text = differentDishes.titleDish
            tvDifferentDishDescr.text = differentDishes.descriptionDish
            differentDishPrice.text = String.format("%s", differentDishes.priceDish)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DifferentDishItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.different_dish_item,
            parent,
            false)
        return DifferentDishItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DifferentDishItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
        holder.binding.btnOrderDifferentDish.setOnClickListener {
            onAddItemClickListener?.invoke(item)
        }
    }
}