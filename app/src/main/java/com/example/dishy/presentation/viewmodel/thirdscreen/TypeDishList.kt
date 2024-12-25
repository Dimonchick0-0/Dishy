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
                id = 0,
                title = "Горячие блюда",
                image = R.drawable.hotdishes
            ),
            TypeDish(
                id = 0,
                title = "Горячие блюда",
                image = R.drawable.hotdishes
            )
        )
    }
}