package com.example.dishy.presentation.recycler.commonadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dishy.R
import com.example.dishy.databinding.DifferentTypeDishBinding
import com.example.dishy.domain.entity.TypeDish

class CommonAdapter : ListAdapter<TypeDish,
        CommonAdapter.CommonDishViewHolder>(DifferentTypeDishCallbackDiffUtil()) {

    var onItemClickListener: ((TypeDish) -> Unit)? = null

    class CommonDishViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = DifferentTypeDishBinding.bind(item)
        fun setData(typeDish: TypeDish) = with(binding) {
            Glide.with(itemView)
                .load(typeDish.image)
                .apply(RequestOptions().override(700, 700))
                .into(imDifferentType)
            tvDifferentType.text = typeDish.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonDishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.different_type_dish,
            parent,
            false
        )
        return CommonDishViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommonDishViewHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
        holder.binding.cardSpecificTypeDish.setOnClickListener {
            onItemClickListener?.invoke(item)
        }
    }
}