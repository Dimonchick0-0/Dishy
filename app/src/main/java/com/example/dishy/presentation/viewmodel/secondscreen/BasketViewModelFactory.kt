package com.example.dishy.presentation.viewmodel.secondscreen

import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.dishy.presentation.fragment.BasketFragment

class BasketViewModelFactory<T: ViewModel>(
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val create: (stateHandle: SavedStateHandle) -> T
): AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return create.invoke(handle) as T
    }
}

inline fun <reified T : ViewModel> BasketFragment.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    BasketViewModelFactory(this, create)
}