package com.example.dishy.presentation.viewmodel.thirdscreen

import com.example.dishy.R
import com.example.dishy.domain.entity.TypeDish
import javax.inject.Inject

class TypeDishList @Inject constructor() {
    fun setTypeDishList(): MutableList<TypeDish> {
        return mutableListOf(
            TypeDish(
                id = 0,
                title = "Горячие блюда",
                image = R.drawable.hotdishes
            ),
            TypeDish(
                id = 1,
                title = "Холодные блюда",
                image = R.drawable.colddishes
            ),
            TypeDish(
                id = 2,
                title = "Горячие напитки",
                image = R.drawable.hotdrinks
            ),
            TypeDish(
                id = 3,
                title = "Холодные напитки",
                image = R.drawable.coldnapitky
            ),
            TypeDish(
                id = 4,
                title = "Салаты",
                image = R.drawable.salat
            )
        )
    }
}