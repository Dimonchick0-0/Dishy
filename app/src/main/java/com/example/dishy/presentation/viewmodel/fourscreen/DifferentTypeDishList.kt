package com.example.dishy.presentation.viewmodel.fourscreen

import com.example.dishy.R
import com.example.dishy.domain.emun.DifferentTypeDish
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.TypeDish
import javax.inject.Inject

class DifferentTypeDishList @Inject constructor() {
    fun setDifferentTypeDishList(): List<TypeDish> {
        return listOf(
            TypeDish(
                id = 0,
                title = "Супы",
                image = R.drawable.chickensoup,
                differentTypeDish = DifferentTypeDish.SOUP,
                dishyType = DishyType.HOT_DISH
            ),
            TypeDish(
                id = 1,
                title = "Салаты",
                image = R.drawable.salat,
                differentTypeDish = DifferentTypeDish.SALADS,
                dishyType = DishyType.COLD_DISH
            ),
            TypeDish(
                id = 2,
                title = "Чай",
                image = R.drawable.tea,
                differentTypeDish = DifferentTypeDish.TEA,
                dishyType = DishyType.HOT_DRINKS
            ),
            TypeDish(
                id = 3,
                title = "Кофе",
                image = R.drawable.coffee,
                differentTypeDish = DifferentTypeDish.COFFEE,
                dishyType = DishyType.HOT_DRINKS
            ),
            TypeDish(
                id = 4,
                title = "Холодная кола",
                image = R.drawable.coldcocacola,
                differentTypeDish = DifferentTypeDish.COLA,
                dishyType = DishyType.COLD_DRINKS
            )
        )
    }
}