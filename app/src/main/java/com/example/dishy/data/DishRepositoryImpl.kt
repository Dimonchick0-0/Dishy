package com.example.dishy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dishy.data.datasoutce.LocalDataSource
import com.example.dishy.data.db.DishBasketDao
import com.example.dishy.data.mapper.DishListMapper
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import javax.inject.Inject

class DishRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : DishRepository {
    private val dishListLd = MutableLiveData<List<Dish>>()
    private val initDishList = DishyList()
    private var dishList = mutableListOf<Dish>()

    init {
        setList(initDishList.setListDish())
    }

    override fun getDish(): LiveData<List<Dish>> {
        return dishListLd
    }

    override suspend fun addDishToBasket(dish: Dish) {
        localDataSource.addDishToBasket(dish)
    }

    private fun setList(list: MutableList<Dish>) {
        dishList = list
        updateList()
    }

    private fun updateList() {
        dishListLd.value = dishList.toList()
    }
}