package com.example.dishy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.repository.DishRepository

class DishRepositoryImpl: DishRepository {
    private val dishListLd = MutableLiveData<List<Dish>>()

    override fun getDish(): LiveData<List<Dish>> {
        return dishListLd
    }

}