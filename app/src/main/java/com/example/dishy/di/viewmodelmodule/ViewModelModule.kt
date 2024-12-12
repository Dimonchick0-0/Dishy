package com.example.dishy.di.viewmodelmodule

import androidx.lifecycle.ViewModel
import com.example.dishy.presentation.viewmodel.firstscreen.ChooseDishViewModel
import com.example.dishy.presentation.viewmodel.secondscreen.BasketDishViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(ChooseDishViewModel::class)
    @Binds
    fun bindChooseViewModel(impl: ChooseDishViewModel): ViewModel

    @IntoMap
    @ViewModelKey(BasketDishViewModel::class)
    @Binds
    fun bindBasketViewModel(impl: BasketDishViewModel): ViewModel
}