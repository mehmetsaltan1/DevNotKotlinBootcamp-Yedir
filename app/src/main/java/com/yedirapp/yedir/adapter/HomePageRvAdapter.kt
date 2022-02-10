package com.yedirapp.yedir.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.yedirapp.yedir.databinding.HomePageCardDesignBinding
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.viewmodel.HomePageViewModel

class HomePageRvAdapter(var mContext: Context, var foodsList: List<Foods>, var viewModel: HomePageViewModel) :
RecyclerView.Adapter<HomePageRvAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(cardDesignBinding: HomePageCardDesignBinding) :
        RecyclerView.ViewHolder(cardDesignBinding.root) {
        var cardDesignBinding: HomePageCardDesignBinding

        init {
            this.cardDesignBinding = cardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = HomePageCardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodsList.get(position)
        val t = holder.cardDesignBinding
        t.foodObj = food
       /* t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }*/

    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

}