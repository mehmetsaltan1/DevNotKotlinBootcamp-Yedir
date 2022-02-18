package com.yedirapp.yedir.entity

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class FoodsDescription(
    var food_description: String? = "",
    var food_categori: String? = "",
    var food_calori: String? = "",
    var food_yore: String? = ""
) : Serializable {

}

