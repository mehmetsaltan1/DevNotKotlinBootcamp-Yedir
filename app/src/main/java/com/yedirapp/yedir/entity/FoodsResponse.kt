package com.yedirapp.yedir.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FoodsResponse(@SerializedName("yemekler") @Expose var foods: List<Foods>,
                         @SerializedName("success") @Expose var success: Int) {
}
