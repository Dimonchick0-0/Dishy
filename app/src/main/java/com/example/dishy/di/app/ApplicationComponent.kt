package com.example.dishy.di.app

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.dishy.di.DataModule
import com.example.dishy.di.DomainModule
import com.example.dishy.presentation.viewmodel.secondscreen.BasketDishFactory
import com.example.dishy.presentation.viewmodel.firstscreen.ChooseDishViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(fragment: Fragment)

    fun getChooseDishViewModel(): ChooseDishViewModel.Factory

    fun getBasketDishViewModel(): BasketDishFactory

    @Component.Builder
    interface ApplicationComponentBuilder {

        @BindsInstance
        fun application(application: Application): ApplicationComponentBuilder

        fun build(): ApplicationComponent
    }
}