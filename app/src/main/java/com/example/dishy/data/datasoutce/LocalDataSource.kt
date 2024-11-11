package com.example.dishy.data.datasoutce

import androidx.lifecycle.LiveData
import com.example.dishy.data.db.DishBasketDatabase
import com.example.dishy.domain.entity.Dish

interface LocalDataSource {

   suspend fun addDishToBasket(dish: Dish)

    fun getDishBasket(): LiveData<List<DishBasketDatabase>>
}