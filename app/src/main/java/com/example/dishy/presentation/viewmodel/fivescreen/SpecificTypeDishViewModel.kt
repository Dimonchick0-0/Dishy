package com.example.dishy.presentation.viewmodel.fivescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dishy.data.repository.DishRepositoryImpl
import com.example.dishy.domain.emun.DifferentTypeDish
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.TypeDish
import kotlinx.coroutines.launch
import javax.inject.Inject

class SpecificTypeDishViewModel @Inject constructor(
    private val initSpecificTypeDishList: SpecificTypeDishList,
    private val repositoryImpl: DishRepositoryImpl
): ViewModel() {
    private var dishList = listOf<Dish>()
    private var _dishListLD = MutableLiveData<List<Dish>>()
    val dishListLD: LiveData<List<Dish>> = _dishListLD

    init {
        setList(initSpecificTypeDishList.setSpecificTypeDishList())
    }

    fun addToBasket(dish: Dish) {
        viewModelScope.launch {
            val newDish = dish.copy(basketID = false)
            repositoryImpl.addDishToBasket(newDish)
        }
    }

    fun determineTheTypeOfDish(type: DifferentTypeDish) {
        when (type) {
            DifferentTypeDish.SOUP -> setDetermineTheTypeOfDish(type)
            DifferentTypeDish.MEAT -> TODO()
            DifferentTypeDish.SALADS -> setDetermineTheTypeOfDish(type)
            DifferentTypeDish.TEA -> setDetermineTheTypeOfDish(type)
            DifferentTypeDish.COFFEE -> setDetermineTheTypeOfDish(type)
            DifferentTypeDish.COLA -> setDetermineTheTypeOfDish(type)
        }
    }

    private fun setDetermineTheTypeOfDish(type: DifferentTypeDish) {
        val itemDishList = mutableListOf<Dish>()
        initSpecificTypeDishList.setSpecificTypeDishList()
            .filter { it.differentTypeDish == type }
            .forEach {
                itemDishList.add(it)
                _dishListLD.value = itemDishList
            }
    }

    private fun setList(list: List<Dish>) {
        dishList = list
        updateLis()
    }

    private fun updateLis() {
        _dishListLD.value = dishList.toList()
    }
}