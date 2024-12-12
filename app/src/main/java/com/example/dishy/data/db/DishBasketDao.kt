package com.example.dishy.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dishy.domain.entity.Dish
import kotlinx.coroutines.flow.Flow

@Dao
interface DishBasketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDishBasket(dishBasketDatabase: DishBasketDatabase)

    @Query("SELECT * FROM basket ORDER BY id ASC")
    fun loadAllDishBasket(): LiveData<List<Dish>>

    @Delete
    suspend fun deleteDishItem(dishBasketDatabase: DishBasketDatabase)

    @Update
    suspend fun updateItemDish(dishBasketDatabase: DishBasketDatabase)
}