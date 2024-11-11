package com.example.dishy.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.dishy.data.DishRepositoryImpl
import com.example.dishy.domain.usecase.GetListDishUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class ChooseDishViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val getListDishUseCase: GetListDishUseCase
) : ViewModel() {

    val dishList = getListDishUseCase()

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ChooseDishViewModel
    }
}