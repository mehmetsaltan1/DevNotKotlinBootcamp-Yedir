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