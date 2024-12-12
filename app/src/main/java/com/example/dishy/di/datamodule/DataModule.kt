package com.example.dishy.di.datamodule

import com.example.dishy.data.datasoutce.LocalDataSource
import com.example.dishy.data.datasoutce.LocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindDishLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

}