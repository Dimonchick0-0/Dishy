package com.example.dishy.domain.entity

data class DifferentDishes(
    val id: Int = UNDEFINED_ID,
    val image: Int = UNDEFINED_IMAGE,
    val titleDish: String = UNDEFINED_TITLE,
    val descriptionDish: String = UNDEFINED_DESCR,
    var basketID: Boolean = false
) {
    companion object {
        private const val UNDEFINED_ID = 0
        private const val UNDEFINED_TITLE = ""
        private const val UNDEFINED_DESCR = ""
        private const val UNDEFINED_IMAGE = 0
    }
}
