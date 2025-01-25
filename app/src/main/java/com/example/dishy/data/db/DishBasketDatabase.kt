package com.example.dishy.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dishy.domain.emun.DifferentTypeDish
import com.example.dishy.domain.emun.DishyType

@Entity(tableName = "basket")
data class DishBasketDatabase (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: Int,
    val titleDish: String,
    val descriptionDish: String,
    val priceDish: Int,
    val basketID: Boolean,
    val dishyType: DishyType,
    val differentTypeDish: DifferentTypeDish
)
