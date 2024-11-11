package com.example.dishy.di

import android.app.Application
import com.example.dishy.data.datasoutce.LocalDataSource
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import com.example.dishy.data.db.AppDatabase
import com.example.dishy.data.db.DishBasketDao
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindDishLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

}