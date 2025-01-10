package com.example.dishy.domain.entity

import com.example.dishy.domain.emun.DishyType

data class DifferentDishes(
    val id: Int = UNDEFINED_ID,
    val image: Int = UNDEFINED_IMAGE,
    val titleDish: String = UNDEFINED_TITLE,
    val descriptionDish: String = UNDEFINED_DESCR,
    val priceDish: Int = UNDEFINED_PRICE,
    var basketID: Boolean = false,
    val dishyType: DishyType
) {
    companion object {
        private const val UNDEFINED_ID = 0
        private const val UNDEFINED_TITLE = ""
        private const val UNDEFINED_DESCR = ""
        private const val UNDEFINED_IMAGE = 0
        private const val UNDEFINED_PRICE = 0
    }
}
