package com.example.dishy.data.datasoutce

import androidx.lifecycle.LiveData
import com.example.dishy.data.db.DishBasketDatabase
import com.example.dishy.data.db.Test
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val db: Test
): LocalDataSource {
    override suspend fun addDishToBasket(dish: Dish) {
        db.addDishToBasket(dish)
    }

    override fun getDishBasket(): LiveData<List<DishBasketDatabase>> {
        return db.getDishIsBasket()
    }
}