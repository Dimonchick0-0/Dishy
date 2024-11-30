package com.example.dishy.presentation.viewmodel.secondscreen

import androidx.lifecycle.SavedStateHandle
import dagger.assisted.AssistedFactory

@AssistedFactory
interface BasketDishFactory {
    fun create(savedStateHandle: SavedStateHandle): BasketDishViewModel
}