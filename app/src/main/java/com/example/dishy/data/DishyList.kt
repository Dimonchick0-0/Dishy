package com.example.dishy.data

import com.example.dishy.R
import com.example.dishy.domain.entity.Dish

class DishyList {
    fun setListDish(): MutableList<Dish> {
        return mutableListOf(
            Dish(
                image = R.drawable.chickensoup,
                titleDish = "Куринный суп",
                descriptionDish = "Всеми горячо любимый куринный супчик!",
                priceDish = 500
            ),
            Dish(
                image = R.drawable.chickensoup,
                titleDish = "Куринный суп номер 2",
                descriptionDish = "Всеми горячо любимый куринный супчик!",
                priceDish = 500
            ),
            Dish(
                image = R.drawable.salat,
                titleDish = "Итальянский салат с копчённой курицей",
                descriptionDish = "Попробуйте Италию на вкус...",
                priceDish = 1200
            )
        )
    }
}