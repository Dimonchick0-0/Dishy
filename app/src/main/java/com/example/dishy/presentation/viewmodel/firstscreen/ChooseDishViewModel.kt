package com.example.dishy.presentation.viewmodel.firstscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private var _dish = MutableLiveData<Dish>()
    val dish: LiveData<Dish> = _dish

    fun addDish(dish: Dish) {
        viewModelScope.launch {
            val newDish = dish.copy(
                id = dish.id,
                image = dish.image,
                titleDish = dish.titleDish,
                descriptionDish = dish.descriptionDish,
                basketID = true
            )
            repository.addDishToBasket(newDish)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ChooseDishViewModel
    }
}