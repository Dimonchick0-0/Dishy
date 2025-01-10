package com.example.dishy.di.domainmodule

import com.example.dishy.data.repository.DishRepositoryImpl
import com.example.dishy.domain.repository.DishRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindRepository(impl: DishRepositoryImpl): DishRepository
}