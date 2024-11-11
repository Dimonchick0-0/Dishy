package com.example.dishy.di

import dagger.Component

@Component
interface ApplicationComponent {

    @Component.Builder
    interface ApplicationComponentBuilder {
        fun build(): ApplicationComponent
    }
}