package com.example.dishy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import com.example.dishy.presentation.viewmodel.firstscreen.DifferentDishList
import javax.inject.Inject

class DishRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSourceImpl
) : DishRepository, DishAddingToBasket {
    private val dishListLdDish = MutableLiveData<List<Dish>>()
    private val dishListLdDifferentDishes = MutableLiveData<List<DifferentDishes>>()
    private val initDishList = DishyList()
    private var dishList = mutableListOf<Dish>()
    private var differentDishList = mutableListOf<DifferentDishes>()
    private val initDifferentDishes = DifferentDishList()

    init {
        setList(initDishList.setListDish(), initDifferentDishes.setDifferentDishesList())
    }

    override suspend fun add(dish: Dish) {
        localDataSource.addDishToBasket(dish)
    }

    override suspend fun add(differentDishes: DifferentDishes) {
        localDataSource.addDishToBasket(differentDishes)
    }

    override fun getDifferentDish(): LiveData<List<DifferentDishes>> {
        return dishListLdDifferentDishes
    }

    override fun getDish(): LiveData<List<Dish>> {
        return dishListLdDish
    }

    override fun loadAllDishBasket(): LiveData<List<Dish>> {
        return localDataSource.loadAllDishBasket()
    }

    override suspend fun deleteDishItem(dish: Dish) {
        localDataSource.deleteDishItem(dish)
    }

    override suspend fun updateDishItem(dish: Dish) {
        localDataSource.updateItemDish(dish)
    }

    fun getAllPrice(priceDish: Int): LiveData<List<Dish>> {
        return localDataSource.getPrice(priceDish)
    }

    private fun setList(list: MutableList<Dish>, listDifferent: MutableList<DifferentDishes>) {
        dishList = list
        differentDishList = listDifferent
        updateList()
    }

    private fun updateList() {
        dishListLdDish.value = dishList.toList()
        dishListLdDifferentDishes.value = differentDishList.toList()
    }
}