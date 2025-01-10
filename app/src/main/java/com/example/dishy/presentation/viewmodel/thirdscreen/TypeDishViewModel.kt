package com.example.dishy.presentation.viewmodel.thirdscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dishy.data.listDish.DifferentListDishy
import com.example.dishy.domain.entity.Dishy
import javax.inject.Inject

class TypeDishViewModel @Inject constructor(
    private val initDishyList: DifferentListDishy
) : ViewModel() {
    private var dishyList = listOf<Dishy>()

    private var _dishyListLD = MutableLiveData<List<Dishy>>()
    val dishyListLD: LiveData<List<Dishy>> = _dishyListLD

    init {
        setList(initDishyList.typeDishList())
    }

    private fun setList(list: List<Dishy>) {
        dishyList = list
        updateList()
    }

    private fun updateList() {
        _dishyListLD.value = dishyList.toList()
    }
}