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
/* Firebase'den gelen verileri karşılamak için oluşturduğum data classım, burada kullanılan Serializable anahtar kelimesi
sayfalar arasında geçiş yaparken kullanılanmasın kaynaklıyor çünkü bu verileri anasayfadan detay sayfasına geçerken kullanıyorum.
 */
}

