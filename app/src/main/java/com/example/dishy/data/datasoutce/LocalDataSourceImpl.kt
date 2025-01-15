package com.example.dishy.data.datasoutce

import androidx.lifecycle.LiveData
import com.example.dishy.data.db.DishBasketDao
import com.example.dishy.data.mapper.DishListMapper
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val mapper: DishListMapper,
    private val dishBasketDao: DishBasketDao
) : LocalDataSource {

    override fun getPrice(price: Int): LiveData<List<Dish>> {
        return dishBasketDao.getPrice(price)
    }

    override suspend fun addDishToBasket(dish: Dish) {
        dishBasketDao.insertDishBasket(mapper.mapEntityToDbModel(dish))
    }

    override suspend fun addDishToBasket(differentDishes: DifferentDishes) {
        dishBasketDao.insertDishBasket(mapper.mapEntityToDbModel(differentDishes))
    }

    override fun loadAllDishBasket(): LiveData<List<Dish>> {
        return dishBasketDao.loadAllDishBasket()
    }

    override suspend fun deleteDishItem(dish: Dish) {
        dishBasketDao.deleteDishItem(mapper.mapEntityToDbModel(dish))
    }

    override suspend fun updateItemDish(dish: Dish) {
        dishBasketDao.updateItemDish(mapper.mapEntityToDbModel(dish))
    }
}