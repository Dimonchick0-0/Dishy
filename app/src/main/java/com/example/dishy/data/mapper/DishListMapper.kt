package com.example.dishy.data.mapper

import com.example.dishy.data.db.DishBasketDatabase
import com.example.dishy.domain.entity.DifferentDishes
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.domain.entity.TypeDish
import javax.inject.Inject

class DishListMapper @Inject constructor() {
    fun mapDbModelToEntity(dishBasketDatabase: DishBasketDatabase) = Dish(
        id = dishBasketDatabase.id,
        image = dishBasketDatabase.image,
        titleDish = dishBasketDatabase.titleDish,
        descriptionDish = dishBasketDatabase.descriptionDish,
        priceDish = dishBasketDatabase.priceDish,
        dishyType = dishBasketDatabase.dishyType
    )

    fun mapEntityToDbModel(dish: Dish) = DishBasketDatabase(
        id = dish.id,
        image = dish.image,
        titleDish = dish.titleDish,
        descriptionDish = dish.descriptionDish,
        priceDish = dish.priceDish,
        basketID = dish.basketID,
        dishyType = dish.dishyType
    )

    fun mapEntityToDbModel(differentDishes: DifferentDishes) = DishBasketDatabase(
        id = differentDishes.id,
        image = differentDishes.image,
        titleDish = differentDishes.titleDish,
        descriptionDish = differentDishes.descriptionDish,
        priceDish = differentDishes.priceDish,
        basketID = differentDishes.basketID,
        dishyType = differentDishes.dishyType
    )
}