package com.yedirapp.yedir.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BasketFoods(
    @SerializedName("sepet_yemek_id") @Expose var basket_food_id: Int,
    @SerializedName("yemek_adi") @Expose var food_name: String,
    @SerializedName("yemek_resim_adi") @Expose var food_image_name: String,
    @SerializedName("yemek_fiyat") @Expose var food_price: Int,
    @SerializedName("yemek_siparis_adet") @Expose var food_total: Int,
    @SerializedName("kullanici_adi") @Expose var username: String,
) : Serializable {

}
