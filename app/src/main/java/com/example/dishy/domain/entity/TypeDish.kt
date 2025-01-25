package com.example.dishy.domain.entity

import android.os.Parcelable
import com.example.dishy.domain.emun.DifferentTypeDish
import com.example.dishy.domain.emun.DishyType
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDish(
    val id: Int = UNDEFINED_ID,
    val title: String = UNDEFINED_TITLE,
    val image: Int = UNDEFINED_IMAGE,
    val differentTypeDish: DifferentTypeDish,
    val dishyType: DishyType
): Parcelable {
    companion object {
        private const val UNDEFINED_ID = 0
        private const val UNDEFINED_TITLE = ""
        private const val UNDEFINED_IMAGE = 0
    }
}