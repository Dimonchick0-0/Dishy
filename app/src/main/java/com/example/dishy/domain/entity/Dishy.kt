package com.example.dishy.domain.entity

import com.example.dishy.domain.emun.DishyType

abstract class Dishy(
    val id: Int,
    val image: Int,
    val title: String,
    val description: String = UNDEFINED_DESCR,
    val price: Int = UNDEFINED_PRICE,
    val basketID: Boolean = false,
    val dishyType: DishyType
) {
    companion object {
        private const val UNDEFINED_DESCR = ""
        private const val UNDEFINED_PRICE = 0
    }
}