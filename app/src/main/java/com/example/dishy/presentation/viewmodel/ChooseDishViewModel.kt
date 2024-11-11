package com.example.dishy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dishy.data.DishRepositoryImpl
import com.example.dishy.domain.usecase.GetListDishUseCase
import javax.inject.Inject

class ChooseDishViewModel: ViewModel() {
    private val repository = DishRepositoryImpl()
    private val getListDishUseCase = GetListDishUseCase(repository)

    val dishList = getListDishUseCase()
}