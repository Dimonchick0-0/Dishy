package com.example.dishy.domain.repository

import androidx.lifecycle.LiveData
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish

interface DishRepository {
    fun getDish(): LiveData<List<Dish>>

    fun getDifferentDish(): LiveData<List<DifferentDishes>>

    fun loadAllDishBasket(): LiveData<List<Dish>>

    suspend fun deleteDishItem(dish: Dish)

    suspend fun updateDishItem(dish: Dish)
}