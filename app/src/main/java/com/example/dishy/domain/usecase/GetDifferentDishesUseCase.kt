package com.example.dishy.domain.usecase

import androidx.lifecycle.LiveData
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.repository.DishRepository
import javax.inject.Inject

class GetDifferentDishesUseCase @Inject constructor(
    private val repository: DishRepository
) {
    operator fun invoke(): LiveData<List<DifferentDishes>> {
        return repository.getDifferentDish()
    }
}