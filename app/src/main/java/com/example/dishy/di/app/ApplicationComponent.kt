package com.example.dishy.di.app

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.dishy.di.DataModule
import com.example.dishy.di.DomainModule
import com.example.dishy.presentation.viewmodel.ChooseDishViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(fragment: Fragment)

    fun getChooseDishViewModel(): ChooseDishViewModel.Factory

    @Component.Builder
    interface ApplicationComponentBuilder {

        @BindsInstance
        fun application(application: Application): ApplicationComponentBuilder

        fun build(): ApplicationComponent
    }
}