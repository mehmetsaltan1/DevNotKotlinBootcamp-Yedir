package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.repo.FoodsDaoRepository

class BasketPageViewModel:ViewModel() {
    val username:String = "mehmet_saltan"
    var frepo = FoodsDaoRepository()
    var basketFoodsList = MutableLiveData<List<BasketFoods>>()

    init {
        loadBasketFoods(username)
        basketFoodsList = frepo.getBasketFoods()
    }
    fun loadBasketFoods(username: String){
        frepo.getAllBasketFoods(username)
    }
    fun deleteFoodBasket(basket_food_id: Int,
                         username: String) {
        frepo.deleteFoodBasket(basket_food_id,username)
    }
}