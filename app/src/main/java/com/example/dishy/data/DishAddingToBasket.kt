package com.example.dishy.data

import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish

interface DishAddingToBasket {
    suspend fun add(dish: Dish)
    suspend fun add(differentDishes: DifferentDishes)
}