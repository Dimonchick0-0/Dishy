package com.example.dishy.presentation.viewmodel.secondscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dishy.data.DishRepositoryImpl
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import com.example.dishy.domain.entity.Dish
import kotlinx.coroutines.launch
import javax.inject.Inject

class BasketDishViewModel @Inject constructor(
    private var repositoryImpl: DishRepositoryImpl,
    private val localDataSourceImpl: LocalDataSourceImpl
) : ViewModel() {
    val loadAllDish: LiveData<List<Dish>>

    init {
        repositoryImpl = DishRepositoryImpl(localDataSourceImpl)
        loadAllDish = repositoryImpl.loadAllDishBasket()
    }

    fun deleteItem(dish: Dish) {
        viewModelScope.launch {
            val newItem = dish.copy(
                id = dish.id,
                image = dish.image,
                titleDish = dish.titleDish,
                descriptionDish = dish.descriptionDish,
                basketID = false
            )
            repositoryImpl.deleteDishItem(newItem)
        }
    }
}