package com.yedirapp.yedir.repo

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.android.material.snackbar.Snackbar
import com.yedirapp.yedir.entity.*
import com.yedirapp.yedir.retrofit.ApiUtils
import com.yedirapp.yedir.retrofit.FoodsDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodsDaoRepository {

    var foodsList: MutableLiveData<List<Foods>>
    var basketFoodsList: MutableLiveData<List<BasketFoods>>
    var fdao: FoodsDaoInterface
    init {
        fdao = ApiUtils.getFoodsDaoInterface()
        foodsList = MutableLiveData()
        basketFoodsList = MutableLiveData()

    }

    fun getFoods(): MutableLiveData<List<Foods>> {
        return foodsList
    }

    fun getAllFoods() {
        fdao.allFoods().enqueue(object : Callback<FoodsResponse> {
            override fun onFailure(call: Call<FoodsResponse>?, t: Throwable?) {}
            override fun onResponse(call: Call<FoodsResponse>, response: Response<FoodsResponse>) {
                val list = response.body().foods
                foodsList.value = list
            }
        })
    }

    fun getBasketFoods(): MutableLiveData<List<BasketFoods>> {
        return basketFoodsList
    }

    fun getAllBasketFoods(username: String) {


        fdao.allBasketFoods(username).enqueue(object : Callback<BasketFoodsResponse> {
            override fun onFailure(call: Call<BasketFoodsResponse>?, t: Throwable?) {
                /*Kullanıcı sepetteki son ürünü de sildiği anda sepet yeni istek attığında faile düştüğünü
                gördüm burada da ekrana boş bir liste gönderdim*/
                basketFoodsList.value = emptyList()
            }

            override fun onResponse(
                call: Call<BasketFoodsResponse>,
                response: Response<BasketFoodsResponse>
            ) {
                Log.e("response", "${response.body()}")
                val list = response.body().basket_foods
                basketFoodsList.value = list
            }
        })
    }

    fun deleteFoodBasket(basket_food_id: Int, username: String) {
        fdao.deleteFoodBasket(basket_food_id, username).enqueue(object : Callback<CrudResponse> {
            override fun onResponse(call: Call<CrudResponse>?, response: Response<CrudResponse>?) {
                getAllBasketFoods(username)
            }

            override fun onFailure(call: Call<CrudResponse>?, t: Throwable?) {}

        })
    }

    fun addFoodBasket(
        food_name: String,
        food_image_name: String,
        food_price: Int,
        food_total: Int,
        username: String
    ) {
        fdao.addFoodBasket(food_name, food_image_name, food_price, food_total, username)
            .enqueue(object : Callback<CrudResponse> {
                override fun onResponse(
                    call: Call<CrudResponse>?,
                    response: Response<CrudResponse>?
                ) {

                    Log.e("başarılı", "$food_name başarılı bir şekilde sepete eklendi")
                }

                override fun onFailure(call: Call<CrudResponse>?, t: Throwable?) {
                    Log.e("başarısız", "$food_name başarısız ")
                }

            })

    }


}