package com.example.dishy.domain.different_dishy

import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dishy

class ColdDrink(
    id: Int,
    image: Int,
    title: String,
    price: Int = 0,
    description: String = "",
    basketID: Boolean = false
): Dishy(id, image, title, description, price, basketID, DishyType.COLD_DRINKS)