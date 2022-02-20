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
    //Azaltma fonksiyonum
    fun decrease(food_total: String, food_price: Int, basket_total: Int) {
        var foodTotal = food_total.toInt()
        var basketTotal = basket_total
        if (foodTotal > 1) { /* Kullanıcı sepetine minumum 1 adet yemek ekleyebileceğinden öncelikle bunun kontrolünü
        yaptım eğer daha küçükse bundan else ile 1 e eşitledim
        */
            foodTotal -= 1
            basketTotal -= food_price
            foodTotalResult.value = foodTotal.toString()
            basketTotalResult.value = basketTotal.toString()
        } else {
            foodTotal = 1
        }
    }
    //Artırma fonksiyonum
    fun increase(food_total: String, food_price: Int, basket_total: Int) {
        var foodTotal = food_total.toInt()
        var basketTotal = basket_total /* Burada bu değer aktarımı yapmamın nedeni fonskiyon parameterleri
        val olarak tanımlandığı için ben de bu değer üzerinde değişiklikler yapmak istediğimden böyle bir yol izledim.
        */
        foodTotal += 1
        basketTotal = food_price * foodTotal
        foodTotalResult.value = foodTotal.toString()
        basketTotalResult.value = basketTotal.toString()

    }

}