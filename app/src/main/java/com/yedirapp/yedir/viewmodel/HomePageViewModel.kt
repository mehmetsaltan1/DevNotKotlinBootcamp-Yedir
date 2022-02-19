package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.entity.FoodsDescription
import com.yedirapp.yedir.repo.FoodsDaoRepository
import com.yedirapp.yedir.repo.FoodsDescriptionRepository

class HomePageViewModel:ViewModel() {
    val username:String = "mehmet_saltan"
    var foodsList = MutableLiveData<List<Foods>>()
    var foodsDescriptionList = MutableLiveData<List<FoodsDescription>>()
    var basketFoodsList = MutableLiveData<List<BasketFoods>>()

    val frepo = FoodsDaoRepository()
    val fDrepo = FoodsDescriptionRepository()

    init {
        loadFoods()
        loadFoodsDescription()
        loadBasketFoods(username)
        basketFoodsList = frepo.getBasketFoods()
        foodsList = frepo.getFoods()
        foodsDescriptionList = fDrepo.getFoodsDescription()
    }
    fun loadFoods(){
        frepo.getAllFoods()
    }
    fun loadBasketFoods(username: String){
        frepo.getAllBasketFoods(username)
    }
    fun loadFoodsDescription(){
        fDrepo.getAllFoodsDescription()
    }
    fun deleteFoodBasket(basket_food_id: Int,
                         username: String) {
        frepo.deleteFoodBasket(basket_food_id,username)
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