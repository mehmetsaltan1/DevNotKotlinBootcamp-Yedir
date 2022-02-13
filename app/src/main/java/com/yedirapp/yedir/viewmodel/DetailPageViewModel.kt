package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.repo.FoodsDaoRepository
import com.yedirapp.yedir.repo.MathematicsRepository

class DetailPageViewModel() : ViewModel() {
    var basketTotalResult = MutableLiveData<String>()
    var foodTotalResult = MutableLiveData<String>()
    var mrepo = MathematicsRepository()

    init {
        foodTotalResult = mrepo.foodTotalResult
        basketTotalResult = mrepo.basketTotalResult
    }

    fun increase(
        food_total: String,
        food_price: Int,
        basket_total: Int
    ) {

        mrepo.increase(food_total, food_price, basket_total)
    }

    fun decrease(
        food_total: String,
        food_price: Int,
        basket_total: Int
    ) {

        mrepo.decrease(
            food_total,
            food_price,
            basket_total
        )
    }

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