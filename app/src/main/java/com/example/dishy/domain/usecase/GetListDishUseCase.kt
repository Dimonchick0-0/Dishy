package com.example.dishy.domain.usecase

import androidx.lifecycle.LiveData
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository

class GetListDishUseCase(
    private val repository: DishRepository
) {
    operator fun invoke(): LiveData<List<Dish>> {
        return repository.getDish()
    }
}