package com.example.dishy.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository
import com.example.dishy.domain.usecase.GetListDishUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class ChooseDishViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val getListDishUseCase: GetListDishUseCase,
    private val repository: DishRepository
) : ViewModel() {

    val dishList = getListDishUseCase()

    fun addDish(dish: Dish) {
        viewModelScope.launch {
            repository.addDishToBasket(dish)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ChooseDishViewModel
    }
}