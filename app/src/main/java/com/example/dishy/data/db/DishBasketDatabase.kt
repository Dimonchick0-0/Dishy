package com.example.dishy.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basket")
data class DishBasketDatabase (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: Int,
    val titleDish: String,
    val descriptionDish: String,
    val priceDish: Int,
    val basketID: Boolean
)
