package com.yedirapp.yedir.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.yedirapp.yedir.entity.FoodsDescription

class FoodsDescriptionRepository {
    var refFoods: DatabaseReference
    var foodsDescriptionList: MutableLiveData<List<FoodsDescription>>

    init {
        val db = FirebaseDatabase.getInstance()
        refFoods = db.getReference("yemekler")
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
                    if(foodDesc!=null){
                        list.add(foodDesc)
                    }
                }
                foodsDescriptionList.value = list
                Log.e("desc","$list")
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}