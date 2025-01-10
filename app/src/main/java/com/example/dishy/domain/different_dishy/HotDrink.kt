package com.example.dishy.domain.different_dishy

import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dishy

class HotDrink(
    id: Int,
    image: Int,
    title: String,
    description: String = "",
    price: Int = 0,
    basketID: Boolean = false
): Dishy(id, image, title, description, price, basketID, DishyType.HOT_DRINKS)