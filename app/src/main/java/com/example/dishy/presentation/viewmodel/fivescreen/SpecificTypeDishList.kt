package com.example.dishy.presentation.viewmodel.fivescreen

import com.example.dishy.R
import com.example.dishy.domain.emun.DifferentTypeDish
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class SpecificTypeDishList @Inject constructor() {
    fun setSpecificTypeDishList(): List<Dish> {
        return listOf(
            Dish(
                image = R.drawable.chickensoup,
                titleDish = "Куринный суп",
                descriptionDish = "Всеми горячо любимый куринный супчик!",
                priceDish = 500,
                dishyType = DishyType.HOT_DISH,
                differentTypeDish = DifferentTypeDish.SOUP
            ),
            Dish(
                image = R.drawable.chickensoup,
                titleDish = "Куринный суп номер 2",
                descriptionDish = "Всеми горячо любимый куринный супчик!",
                priceDish = 500,
                dishyType = DishyType.HOT_DISH,
                differentTypeDish = DifferentTypeDish.SOUP
            ),
            Dish(
                image = R.drawable.salat,
                titleDish = "Итальянский салат с копчённой курицей",
                descriptionDish = "Попробуйте Италию на вкус...",
                priceDish = 1200,
                dishyType = DishyType.COLD_DISH,
                differentTypeDish = DifferentTypeDish.SALADS
            ),
            Dish(
                image = R.drawable.coldcocacola,
                titleDish = "Холодная кока кола",
                descriptionDish = "Очень освежает...",
                priceDish = 150,
                dishyType = DishyType.COLD_DISH,
                differentTypeDish = DifferentTypeDish.COLA
            ),
            Dish(
                image = R.drawable.greentea,
                titleDish = "Зелёный чай",
                descriptionDish = "Для любителей зеленого чая",
                priceDish = 70,
                dishyType = DishyType.HOT_DRINKS,
                differentTypeDish = DifferentTypeDish.TEA
            ),
            Dish(
                image = R.drawable.latte,
                titleDish = "Латте",
                descriptionDish = "Самый вкусный латте",
                priceDish = 120,
                dishyType = DishyType.HOT_DRINKS,
                differentTypeDish = DifferentTypeDish.COFFEE
            )
        )
    }
}