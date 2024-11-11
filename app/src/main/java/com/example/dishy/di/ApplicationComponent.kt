package com.example.dishy.di

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.dishy.presentation.viewmodel.ChooseDishViewModel
import dagger.Binds
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