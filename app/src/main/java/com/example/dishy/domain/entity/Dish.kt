package com.example.dishy.domain.entity

data class Dish (
    val id: Int = UNDEFINED_ID,
    val image: Int = UNDEFINED_IMAGE,
    val titleDish: String = UNDEFINED_TITLE,
    val descriptionDish: String = UNDEFINED_DESCR
) {
    companion object {
        const val UNDEFINED_ID = 0
        const val UNDEFINED_TITLE = ""
        const val UNDEFINED_DESCR = ""
        const val UNDEFINED_IMAGE = 0
    }
}
