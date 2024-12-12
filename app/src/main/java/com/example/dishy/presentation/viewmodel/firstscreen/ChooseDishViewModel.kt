package com.example.dishy.presentation.viewmodel.firstscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dishy.data.DishRepositoryImpl
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import com.example.dishy.domain.usecase.GetDifferentDishesUseCase
import com.example.dishy.domain.usecase.GetListDishUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChooseDishViewModel @Inject constructor(
    private val getListDishUseCase: GetListDishUseCase,
    private val getDifferentDishesUseCase: GetDifferentDishesUseCase,
    private val repository: DishRepositoryImpl
) : ViewModel() {

    val dishList = getListDishUseCase()
    val differentDishList = getDifferentDishesUseCase()

    private var _dish = MutableLiveData<Dish>()
    val dish: LiveData<Dish> = _dish

    fun addDishToBasket(dish: Dish) {
        viewModelScope.launch {
            val newDish = dish.copy(
                id = dish.id,
                image = dish.image,
                titleDish = dish.titleDish,
                descriptionDish = dish.descriptionDish,
                basketID = true
            )
            repository.add(newDish)
        }
    }

    fun addDifferentDishToBasket(differentDishes: DifferentDishes) {
        viewModelScope.launch {
            val newDish = differentDishes.copy(
                id = differentDishes.id,
                image = differentDishes.image,
                titleDish = differentDishes.titleDish,
                descriptionDish = differentDishes.descriptionDish,
                basketID = true
            )
            repository.add(newDish)
        }
    }
}