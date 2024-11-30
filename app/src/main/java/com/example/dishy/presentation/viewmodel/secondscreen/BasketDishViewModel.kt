package com.example.dishy.presentation.viewmodel.secondscreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.dishy.data.DishRepositoryImpl
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import com.example.dishy.data.db.AppDatabase
import com.example.dishy.data.db.DishBasketDatabase
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.usecase.LoadAllDishBasketUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BasketDishViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private var repositoryImpl: DishRepositoryImpl,
    private val localDataSourceImpl: LocalDataSourceImpl
) : ViewModel() {
    val loadAllDish: LiveData<List<Dish>>

    init {
        repositoryImpl = DishRepositoryImpl(localDataSourceImpl)
        loadAllDish = repositoryImpl.loadAllDishBasket()
    }
}