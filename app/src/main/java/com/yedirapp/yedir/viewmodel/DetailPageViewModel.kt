package com.yedirapp.yedir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.repo.FoodsDaoRepository
import com.yedirapp.yedir.repo.MathematicsRepository

class DetailPageViewModel() : ViewModel() {
    val username:String = "mehmet_saltan"
    var basketTotalResult = MutableLiveData<String>()
    var foodTotalResult = MutableLiveData<String>()
    var mrepo = MathematicsRepository()
    var frepo = FoodsDaoRepository()
    var basketFoodsList = MutableLiveData<List<BasketFoods>>()
    init {
        foodTotalResult = mrepo.foodTotalResult()
        basketTotalResult = mrepo.basketTotalResult()
        loadBasketFoods(username)
        basketFoodsList = frepo.getBasketFoods()
    }
    //Artırma fonksiyonum
    fun increase(
        food_total: String,
        food_price: Int,
        basket_total: Int
    ) {

        mrepo.increase(food_total, food_price, basket_total)
    }
    //Azaltma fonksiyonum
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
    //Sepetteki yemekleri yüklediğim fonksiyonum
    fun loadBasketFoods(username: String){
        frepo.getAllBasketFoods(username)
    }
    //Sepetteki yemekleri sildiğim fonksiyonum
    fun deleteFoodBasket(basket_food_id: Int,
                         username: String) {
        frepo.deleteFoodBasket(basket_food_id,username)
    }
    //Sepete yemek ekleme fonksiyonum
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