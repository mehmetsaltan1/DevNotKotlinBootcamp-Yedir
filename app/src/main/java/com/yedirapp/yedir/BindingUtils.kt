package com.yedirapp.yedir

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    /*Burada yaptığım işlemde araştırmalarım sonucunda Data Binding ile Picasso kütüphanesinin çalışma
    prensibinin bu olduğunu öğrenip adapterda her resim için yükleme yapmaktansa direkt olarak card design
    layotumda bulunan food nesnemin image urlini buraya gönderip yüklemesini sağladım. */
    val BASE_URL ="http://kasimadalan.pe.hu/yemekler/resimler/"
    Picasso.get().load(BASE_URL+url).into(view)
}