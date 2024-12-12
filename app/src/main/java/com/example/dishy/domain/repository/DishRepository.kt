package com.example.dishy.domain.repository

import androidx.lifecycle.LiveData
import com.example.dishy.data.db.DishBasketDatabase
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import kotlinx.coroutines.flow.Flow

interface DishRepository {
    fun getDish(): LiveData<List<Dish>>

    fun getDifferentDish(): LiveData<List<DifferentDishes>>

    suspend fun addDishToBasket(dish: Dish)

    fun loadAllDishBasket(): LiveData<List<Dish>>

    suspend fun deleteDishItem(dish: Dish)

    suspend fun updateDishItem(dish: Dish)
}