package com.example.dishy.di

import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface ApplicationComponentBuilder {

        fun build(): ApplicationComponent
    }
}