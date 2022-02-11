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
    fun addFoodBasket(
        food_name: String,
        food_image_name: String,
        food_price: Int,
        food_total: Int,
        username: String
    ) {
        frepo.addFoodBasket(food_name, food_image_name, food_price, food_total, username)
    }
}