package com.example.dishy.presentation.viewmodel.fourscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.TypeDish
import javax.inject.Inject

class CommonForDishViewModel @Inject constructor(
    private val initDifferentTypeDishList: DifferentTypeDishList,
) : ViewModel() {
    private var dishList = listOf<TypeDish>()
    private var _dishListLD = MutableLiveData<List<TypeDish>>()
    val dishListLD: LiveData<List<TypeDish>> = _dishListLD

    init {
        setList(initDifferentTypeDishList.setDifferentTypeDishList())
    }

    fun determineTheTypeOfDish(item: DishyType) {
        when (item) {
            DishyType.HOT_DISH -> setDeterminingTheTypeOfDish(item)
            DishyType.COLD_DISH -> setDeterminingTheTypeOfDish(item)
            DishyType.HOT_DRINKS -> setDeterminingTheTypeOfDish(item)
            DishyType.COLD_DRINKS -> setDeterminingTheTypeOfDish(item)
        }
    }

    private fun setDeterminingTheTypeOfDish(item: DishyType) {
        val itemDishyList = mutableListOf<TypeDish>()
        initDifferentTypeDishList.setDifferentTypeDishList()
            .filter { it.dishyType == item }
            .forEach {
                itemDishyList.add(it)
                _dishListLD.value = itemDishyList
            }
    }

    private fun setList(list: List<TypeDish>) {
        dishList = list
        updateLis()
    }

    private fun updateLis() {
        _dishListLD.value = dishList.toList()
    }
}