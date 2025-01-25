package com.example.dishy.di.datamodule

import android.app.Application
import com.example.dishy.data.repository.DishRepositoryImpl
import com.example.dishy.data.datasoutce.LocalDataSource
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import com.example.dishy.data.db.AppDatabase
import com.example.dishy.data.db.DishBasketDao
import com.example.dishy.di.ApplicationScope
import com.example.dishy.domain.repository.DishRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindDishLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    companion object {
        @ApplicationScope
        @Provides
        fun provideDishDao(application: Application): DishBasketDao {
            return AppDatabase.getInstance(application).dishBasket()
        }
    }
}