package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.repo.FoodsDaoRepository

class BasketPageViewModel(var username: String):ViewModel() {
    var frepo = FoodsDaoRepository()
    var basketFoodsList = MutableLiveData<List<BasketFoods>>()

    init {
        loadBasketFoods()
        basketFoodsList = frepo.getBasketFoods()
    }
    fun loadBasketFoods(){
        frepo.getAllBasketFoods(username)
    }
    fun deleteFoodBasket(basket_food_id: Int,
                         username: String) {
        frepo.deleteFoodBasket(basket_food_id,username)
    }
}