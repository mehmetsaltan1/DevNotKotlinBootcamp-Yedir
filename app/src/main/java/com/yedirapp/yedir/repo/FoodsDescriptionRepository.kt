package com.yedirapp.yedir.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.yedirapp.yedir.entity.FoodsDescription

class FoodsDescriptionRepository {
    var refFoods: DatabaseReference
    var foodsDescriptionList: MutableLiveData<List<FoodsDescription>>
    init {
        val db = FirebaseDatabase.getInstance() // Firebase Database nesnemi oluşturdum
        refFoods = db.getReference("yemekler") /*Üstte oluşturduğum refFoods değişkenime
                                                     referansı olacağı veri tabanını atadım */
        foodsDescriptionList = MutableLiveData()
    }

    fun getFoodsDescription(): MutableLiveData<List<FoodsDescription>> {
        return foodsDescriptionList

    }

    fun getAllFoodsDescription() {
        refFoods.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<FoodsDescription>()
                for (d in snapshot.children){
                    val foodDesc = d.getValue(FoodsDescription::class.java)
                    // Üst bölümde gelecek verinin FoodsDescription türünde bir veri olduğunu belirttim
                    if(foodDesc!=null){ //Burada da gelen verinin boş olup olmadığını kontrol ettim
                        list.add(foodDesc) // Gelen veri boş değilse gelen veriyi listeme ekledim
                    }
                }
                foodsDescriptionList.value = list /* Son olarak Live Data türündeki listemin value'suna
                                                    verileri eklediğim listemi atadım */
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}