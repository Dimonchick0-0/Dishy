package com.example.dishy.domain.repository

import androidx.lifecycle.LiveData
import com.example.dishy.domain.entity.Dish

interface DishRepository {
    fun getDish(): LiveData<List<Dish>>
}