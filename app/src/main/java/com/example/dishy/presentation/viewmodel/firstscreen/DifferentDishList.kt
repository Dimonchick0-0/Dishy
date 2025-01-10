package com.example.dishy.presentation.viewmodel.firstscreen

import com.example.dishy.R
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.DifferentDishes

class DifferentDishList {
    fun setDifferentDishesList(): MutableList<DifferentDishes> {
        return mutableListOf(
            DifferentDishes(
                image = R.drawable.salat,
                titleDish = "Итальянский салат с копчённой курицей",
                descriptionDish = "Попробуйте Италию на вкус...",
                priceDish = 1200,
                dishyType = DishyType.COLD_DISH
            ),
            DifferentDishes(
                image = R.drawable.chickensoup,
                titleDish = "Куринный суп номер 2",
                descriptionDish = "Всеми горячо любимый куринный супчик!",
                priceDish = 500,
                dishyType = DishyType.HOT_DISH
            )
        )
    }
}