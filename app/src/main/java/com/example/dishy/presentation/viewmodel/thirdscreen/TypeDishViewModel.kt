package com.example.dishy.presentation.viewmodel.thirdscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dishy.domain.entity.TypeDish
import javax.inject.Inject

class TypeDishViewModel @Inject constructor(
    private val initTypeDishList: TypeDishList
) : ViewModel() {
    private var typeDishList = mutableListOf<TypeDish>()

    private var _typeDishListLD = MutableLiveData<List<TypeDish>>()
    val typeDishListLD: LiveData<List<TypeDish>> = _typeDishListLD

    init {
        setList(initTypeDishList.setTypeDishList())
    }

    private fun setList(list: MutableList<TypeDish>) {
        typeDishList = list
        updateList()
    }

    private fun updateList() {
        _typeDishListLD.value = typeDishList.toList()
    }
}