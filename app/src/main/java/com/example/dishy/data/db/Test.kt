package com.example.dishy.data.db

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.dishy.data.mapper.DishListMapper
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class Test @Inject constructor(
    private val mapper: DishListMapper,
    private val application: Application
) {
    private val dishBasketDao = AppDatabase.getInstance(application).dishBasket()
    suspend fun addDishToBasket(dish: Dish) {
        dishBasketDao.insertDishBasket(mapper.mapEntityToDbModel(dish))
    }

    fun getDishIsBasket(): LiveData<List<DishBasketDatabase>> =
        MediatorLiveData<List<DishBasketDatabase>>().apply {
            addSource(dishBasketDao.getDishBasket()) {
                mapper.mapListDbModelToListEntity(it)
            }
        }
}