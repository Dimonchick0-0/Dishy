package com.example.dishy.di.viewmodelmodule

import androidx.lifecycle.ViewModel
import com.example.dishy.presentation.viewmodel.checkoutscreen.CheckoutScreenViewModel
import com.example.dishy.presentation.viewmodel.firstscreen.ChooseDishViewModel
import com.example.dishy.presentation.viewmodel.fivescreen.SpecificTypeDishViewModel
import com.example.dishy.presentation.viewmodel.fourscreen.CommonForDishViewModel
import com.example.dishy.presentation.viewmodel.secondscreen.BasketDishViewModel
import com.example.dishy.presentation.viewmodel.thirdscreen.TypeDishViewModel
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

    @IntoMap
    @ViewModelKey(TypeDishViewModel::class)
    @Binds
    fun bindTypeDishViewModel(impl: TypeDishViewModel): ViewModel

    @IntoMap
    @ViewModelKey(CommonForDishViewModel::class)
    @Binds
    fun bindCommonForDishViewModel(impl: CommonForDishViewModel): ViewModel

    @IntoMap
    @ViewModelKey(SpecificTypeDishViewModel::class)
    @Binds
    fun bindSpecificTypeDishModel(impl: SpecificTypeDishViewModel): ViewModel

    @IntoMap
    @ViewModelKey(CheckoutScreenViewModel::class)
    @Binds
    fun bindCheckoutScreenModel(impl: CheckoutScreenViewModel): ViewModel
}