package com.yedirapp.yedir.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData

class MathematicsRepository() {
    var foodTotalResult = MutableLiveData<String>()
    var basketTotalResult = MutableLiveData<String>()

    init {
        foodTotalResult = MutableLiveData<String>("1")
        basketTotalResult = MutableLiveData<String>("1")
    }

    fun foodTotalResult(): MutableLiveData<String> {
        return foodTotalResult
    }


    fun basketTotalResult(): MutableLiveData<String> {
        return basketTotalResult
    }

    fun decrease(food_total: String, food_price: Int, basket_total: Int) {
        var foodTotal = food_total.toInt()
        var basketTotal = basket_total
        if (foodTotal > 1) {
            foodTotal -= 1
            basketTotal -= food_price
            foodTotalResult.value = foodTotal.toString()
            basketTotalResult.value = basketTotal.toString()
        } else {
            foodTotal = 1
        }
    }

    fun increase(food_total: String, food_price: Int, basket_total: Int) {
        var foodTotal = food_total.toInt()
        var basketTotal = basket_total
        foodTotal += 1
        basketTotal = food_price * foodTotal
        foodTotalResult.value = foodTotal.toString()
        basketTotalResult.value = basketTotal.toString()

    }

}