package com.example.dishy.domain.usecase

import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import javax.inject.Inject

class UpdateDishItemUseCase @Inject constructor(
    private val repository: DishRepository
) {
    suspend operator fun invoke(dish: Dish) {
        repository.updateDishItem(dish)
    }
}