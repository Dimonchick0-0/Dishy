package com.example.dishy.domain.usecase

import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import javax.inject.Inject

class AddDishToBasket @Inject constructor(
    private val repository: DishRepository
) {
    operator fun invoke(dish: Dish) {
        repository.addDishToBasket(dish)
    }
}