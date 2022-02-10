package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.repo.FoodsDaoRepository

class HomePageViewModel:ViewModel() {
    var foodsList = MutableLiveData<List<Foods>>()

    val frepo = FoodsDaoRepository()

    init {
        loadFoods()
        foodsList = frepo.getFoods()
    }
    fun loadFoods(){
        frepo.getAllFoods()
    }
}