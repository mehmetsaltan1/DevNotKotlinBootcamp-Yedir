package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.repo.FoodsDaoRepository

class DetailPageViewModel : ViewModel() {
    var frepo = FoodsDaoRepository()
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