package com.example.dishy.presentation.viewmodel.firstscreen

import com.example.dishy.R
import com.example.dishy.domain.entity.DifferentDishes

class DifferentDishList {
    fun setDifferentDishesList(): MutableList<DifferentDishes> {
        return mutableListOf(
            DifferentDishes(
                image = R.drawable.salat,
                titleDish = "Итальянский салат с копчённой курицей",
                descriptionDish = "Попробуйте Италию на вкус..."
            )
        )
    }
}