package com.example.dishy.di.app

import android.app.Application
import com.example.dishy.di.ApplicationScope
import com.example.dishy.di.datamodule.DataModule
import com.example.dishy.di.domainmodule.DomainModule
import com.example.dishy.di.viewmodelmodule.ViewModelModule
import com.example.dishy.presentation.fragment.BasketFragment
import com.example.dishy.presentation.fragment.ChooseDishFragment
import com.example.dishy.presentation.fragment.DifferentDishesFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: ChooseDishFragment)
    fun inject(fragment: BasketFragment)
    fun inject(fragment: DifferentDishesFragment)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}