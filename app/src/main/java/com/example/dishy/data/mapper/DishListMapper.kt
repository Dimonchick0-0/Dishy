package com.example.dishy.data.mapper

import com.example.dishy.data.db.DishBasketDatabase
import com.example.dishy.domain.entity.Dish
import javax.inject.Inject

class DishListMapper @Inject constructor() {
    private fun mapDbModelToEntity(dishBasketDatabase: DishBasketDatabase) = Dish(
        id = dishBasketDatabase.id,
        image = dishBasketDatabase.image,
        titleDish = dishBasketDatabase.titleDish,
        descriptionDish = dishBasketDatabase.descriptionDish
    )
    fun mapEntityToDbModel(dish: Dish) = DishBasketDatabase(
        id = dish.id,
        image = dish.image,
        titleDish = dish.titleDish,
        descriptionDish = dish.descriptionDish,
        basketID = dish.basketID
    )
    fun mapListDbModelToListEntity(list: MutableList<DishBasketDatabase>) = list.map {
        mapDbModelToEntity(it)
    }
}