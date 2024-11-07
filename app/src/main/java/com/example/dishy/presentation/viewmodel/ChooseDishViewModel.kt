package com.example.dishy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dishy.data.DishRepositoryImpl
import com.example.dishy.domain.usecase.GetListDishUseCase

class ChooseDishViewModel: ViewModel() {
    private val repository = DishRepositoryImpl()
    private val getListDishUseCase = GetListDishUseCase(repository)

    val dishList = getListDishUseCase()
}