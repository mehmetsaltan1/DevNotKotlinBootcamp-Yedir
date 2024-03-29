package com.yedirapp.yedir.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.color.MaterialColors.getColor
import com.google.android.material.snackbar.Snackbar
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.BasketCardDesignBinding
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.viewmodel.BasketPageViewModel

class BasketPageRvAdapter(
    var mContext: Context,
    var basketFoodsList: List<BasketFoods>,
    var viewModel: BasketPageViewModel
) :
    RecyclerView.Adapter<BasketPageRvAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(cardDesignBinding: BasketCardDesignBinding) :
        RecyclerView.ViewHolder(cardDesignBinding.root) {
        var cardDesignBinding: BasketCardDesignBinding

        init {
            this.cardDesignBinding = cardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = BasketCardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }
    fun onClickDelete(view: View, basketFoodObj: BasketFoods) {
        Snackbar.make(view, "${basketFoodObj.food_name} silinsin mi ?", Snackbar.LENGTH_LONG)
            .setAction("Evet") {
                viewModel.deleteFoodBasket(basketFoodObj.basket_food_id, basketFoodObj.username)
                /* Burada kullanıcı eğer evet butonuna basarsa view modelde bulunan delete metodunu çağırarak silme
                işlemini başlatıyorum ayrıca her silmeden sonra alttaki verileri yükleme metodumu çağırma sebebim
                anasayfada yer alan sepete eklerkenki aynı yemekten bir tane daha var mı sorgusuna yardım etmek.
                */
                viewModel.loadBasketFoods(basketFoodObj.username)
            }.show()
    }

    fun onClickAllBasketFoodDelete(view: View){
        Snackbar.make(view, "Sepeti boşaltmak istiyor musun ?", Snackbar.LENGTH_LONG)
            .setAction("Evet") {
                for (i in basketFoodsList){
                    viewModel.deleteFoodBasket(i.basket_food_id,"mehmet_saltan")
                }/*Üstte tüm sepeti silme işlemini for döngüsüyle yapmamın nedeni tüm sepeti silme
                apisinin olmamasından ötürü ben de kendimce böyle bir algoritma geliştirdim. */
            }.show()
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val basketFood = basketFoodsList.get(position)
        val t = holder.cardDesignBinding
        t.rvObj = this //Databinding ile Recycler view a ulaşıp silme işlemini gerçekleştirebileyim diye bu atamayı yaptım
        t.basketFoodsObj = basketFood
        val rndNumber = (0..3).random()
        val colorList = listOf("#83A638", "#F2A30F", "#F2780C", "#D93D1A")
        t.cardView5.setCardBackgroundColor(Color.parseColor(colorList.get(rndNumber)))
        //Random sayı türeterek cardlarımın arka plan rengini değiştirdim.

    }

    override fun getItemCount(): Int {
        return basketFoodsList.size
    }

}