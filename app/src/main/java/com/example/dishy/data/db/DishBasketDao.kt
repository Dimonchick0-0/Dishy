package com.example.dishy.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DishBasketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDishBasket(dishBasketDatabase: DishBasketDatabase)

    @Query("SELECT * FROM basket")
    fun getDishBasket(): LiveData<List<DishBasketDatabase>>
}