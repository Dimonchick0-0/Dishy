package com.example.dishy.presentation.viewmodel.checkoutscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import com.example.dishy.data.repository.DishRepositoryImpl
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class CheckoutScreenViewModel @Inject constructor(
    private var repositoryImpl: DishRepositoryImpl,
    private val localDataSourceImpl: LocalDataSourceImpl
): ViewModel() {

    val loadTitleDish: LiveData<List<Dish>>

    init {
        repositoryImpl = DishRepositoryImpl(localDataSourceImpl)
        loadTitleDish = repositoryImpl.loadAllDishBasket()
    }

}