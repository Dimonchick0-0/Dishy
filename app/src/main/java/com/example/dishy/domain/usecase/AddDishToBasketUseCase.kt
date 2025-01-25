package com.example.dishy.domain.usecase

import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import javax.inject.Inject

class AddDishToBasketUseCase @Inject constructor(
    private val dishRepository: DishRepository
) {
    suspend operator fun invoke(dish: Dish) {
        dishRepository.addDishToBasket(dish)
    }
    suspend operator fun invoke(differentDishes: DifferentDishes) {
        dishRepository.addDishToBasket(differentDishes)
    }
}