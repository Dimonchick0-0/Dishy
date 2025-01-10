package com.example.dishy.presentation.viewmodel.fourscreen

import com.example.dishy.R
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class DishesList @Inject constructor() {
    fun setDishesList(): MutableList<Dish> {
        return mutableListOf(
            Dish(
                titleDish = "Суп",
                image = R.drawable.chickensoup,
                descriptionDish = "Всеми горячо любимый куринный супчик!",
                priceDish = 500,
                dishyType = DishyType.HOT_DISH
            ),
            Dish(
                titleDish = "Итальянский салат с копченной курицей",
                image = R.drawable.salat,
                descriptionDish = "Попробуйте на вкус Италию...",
                priceDish = 1200,
                dishyType = DishyType.COLD_DISH
            ),
            Dish(
                titleDish = "Суп",
                image = R.drawable.chickensoup,
                descriptionDish = "Всеми горячо любимый куринный супчик 2!",
                priceDish = 500,
                dishyType = DishyType.HOT_DISH
            )
        )
    }
}