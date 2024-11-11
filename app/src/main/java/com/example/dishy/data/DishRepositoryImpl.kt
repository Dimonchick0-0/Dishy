package com.example.dishy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import javax.inject.Inject

class DishRepositoryImpl @Inject constructor() : DishRepository {
    private val dishListLd = MutableLiveData<List<Dish>>()
    private val initDishList = DishyList()
    private var dishList = mutableListOf<Dish>()

    init {
        setList(initDishList.setListDish())
    }

    override fun getDish(): LiveData<List<Dish>> {
        return dishListLd
    }

    override fun addDishToBasket(dish: Dish) {
        TODO("Not yet implemented")
    }

    private fun setList(list: MutableList<Dish>) {
        dishList = list
        updateList()
    }

    private fun updateList() {
        dishListLd.value = dishList.toList()
    }
}