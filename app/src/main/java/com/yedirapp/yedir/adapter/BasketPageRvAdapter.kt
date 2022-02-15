package com.yedirapp.yedir.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
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

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val basketFood = basketFoodsList.get(position)
        val t = holder.cardDesignBinding
        t.basketFoodsObj = basketFood

        t.imageViewDeleteFood.setOnClickListener {
            Snackbar.make(it, "${basketFood.food_name} silinsin mi ?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.deleteFoodBasket(basketFood.basket_food_id, basketFood.username)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return basketFoodsList.size
    }

}