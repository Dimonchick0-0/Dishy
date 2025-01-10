package com.example.dishy.presentation.viewmodel.fourscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dishy.data.repository.DishRepositoryImpl
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.Dishy
import javax.inject.Inject

class CommonForDishViewModel @Inject constructor(
    private val initTypeDishList: DishesList,
    private val repositoryImpl: DishRepositoryImpl
) : ViewModel() {
    private var dishList = mutableListOf<Dish>()
    private var _dishListLD = MutableLiveData<List<Dish>>()
    val dishListLD: LiveData<List<Dish>> = _dishListLD

    init {
        setList(initTypeDishList.setDishesList())
    }

    fun determineTheTypeOfDish(item: DishyType) {
        val dishyTypes = DishyType.entries
        val dishyTypeIndex = 0
        val dishyType = dishyTypes[dishyTypeIndex]
        when (dishyType) {
            DishyType.HOT_DISH -> setDeterminingTheTypeOfDish(item)
            DishyType.COLD_DISH -> setDeterminingTheTypeOfDish(item)
            DishyType.HOT_DRINKS -> TODO()
            DishyType.COLD_DRINKS -> TODO()
        }
    }

    private fun setDeterminingTheTypeOfDish(item: DishyType) {
        val itemDishyList = mutableListOf<Dish>()
        val dishList = initTypeDishList.setDishesList()
        dishList.forEach {
            if (it.dishyType == item) {
                itemDishyList.add(it)
                _dishListLD.value = itemDishyList
            }
        }
    }

    private fun setList(listHot: MutableList<Dish>) {
        dishList = listHot
        updateLis()
    }

    private fun updateLis() {
        _dishListLD.value = dishList.toList()
    }
}