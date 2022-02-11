package com.yedirapp.yedir.retrofit

import com.yedirapp.yedir.entity.BasketFoodsResponse
import com.yedirapp.yedir.entity.CrudResponse
import com.yedirapp.yedir.entity.FoodsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDaoInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun allFoods(): Call<FoodsResponse>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun allBasketFoods(
        @Field("kullanici_adi") username: String
    ): Call<BasketFoodsResponse>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun addFoodBasket(
        @Field("yemek_adi") food_name: String,
        @Field("yemek_resim_adi") food_image_name: String,
        @Field("yemek_fiyat") food_price: Int,
        @Field("yemek_siparis_adet") food_total: Int,
        @Field("kullanici_adi") username: String
    ): Call<CrudResponse>

    @POST("yemekler/resimler/.php")
    @FormUrlEncoded
    fun getFoodImage(
        @Field("yemek_adi") food_name: String,
    ): Call<CrudResponse>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteFoodBasket(
        @Field("sepet_yemek_id") basket_food_id: Int,
        @Field("kullanici_adi") username: String
    ): Call<CrudResponse>


}