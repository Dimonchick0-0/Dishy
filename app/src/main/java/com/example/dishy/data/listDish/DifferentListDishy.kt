package com.example.dishy.data.listDish

import com.example.dishy.R
import com.example.dishy.domain.different_dishy.ColdDishy
import com.example.dishy.domain.different_dishy.ColdDrink
import com.example.dishy.domain.different_dishy.HotDishy
import com.example.dishy.domain.different_dishy.HotDrink
import com.example.dishy.domain.entity.Dishy
import javax.inject.Inject

class DifferentListDishy @Inject constructor() {
    fun typeDishList(): List<Dishy> {
        return listOf(
            HotDishy(
                id = 0,
                image = R.drawable.hotdishes,
                title = "Горячие блюда"
            ),
            ColdDishy(
                id = 1,
                image = R.drawable.colddishes,
                title = "Холодные блюда"
            ),
            HotDrink(
                id = 2,
                image = R.drawable.hotdrinks,
                title = "Горячие напитки"
            ),
            ColdDrink(
                id = 3,
                image = R.drawable.coldnapitky,
                title = "Холодные напитки"
            )
        )
    }
}