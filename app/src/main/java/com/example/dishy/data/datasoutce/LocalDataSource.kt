package com.example.dishy.data.datasoutce

import androidx.lifecycle.LiveData
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.domain.entity.TypeDish

interface LocalDataSource {
   suspend fun addDishToBasket(dish: Dish)

   suspend fun addDishToBasket(differentDishes: DifferentDishes)

   fun loadAllDishBasket(): LiveData<List<Dish>>

   fun getPrice(price: Int): LiveData<List<Dish>>

   suspend fun deleteDishItem(dish: Dish)

   suspend fun updateItemDish(dish: Dish)
}