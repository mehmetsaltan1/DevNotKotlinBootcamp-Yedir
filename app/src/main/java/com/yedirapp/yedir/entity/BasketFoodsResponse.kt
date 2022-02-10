package com.yedirapp.yedir.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BasketFoodsResponse(@SerializedName("sepet_yemekler") @Expose var basket_foods: List<BasketFoods>,
                               @SerializedName("success") @Expose var success: Int) {
}
