package com.example.dishy.data.datasoutce

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.dishy.data.db.AppDatabase
import com.example.dishy.data.mapper.DishListMapper
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val mapper: DishListMapper,
    private val application: Application
) : LocalDataSource {
    private val dishBasketDao = AppDatabase.getInstance(application).dishBasket()

    override suspend fun addDishToBasket(dish: Dish) {
        dishBasketDao.insertDishBasket(mapper.mapEntityToDbModel(dish))
    }

    override fun loadAllDishBasket(): LiveData<List<Dish>> {
        return dishBasketDao.loadAllDishBasket()
    }
}