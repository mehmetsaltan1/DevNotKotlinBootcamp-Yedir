package com.yedirapp.yedir.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yedirapp.yedir.databinding.HomePageCardDesignBinding
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.fragment.HomePageFragmentDirections

class HomePageRvAdapter(
    var mContext: Context,
    var foodsList: List<Foods>,
) :
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
        val binding = HomePageCardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodsList.get(position)
        val t = holder.cardDesignBinding
        t.foodObj = food
        t.cardViewCategori.setOnClickListener {
            // Nav Args yardımıyla her card'a tıklanınca detay sayfasına o kartta bulunan yemeği gönderdim
            val intent = HomePageFragmentDirections.homePageToDetailPage(food)
            Navigation.findNavController(it).navigate(intent)
        }

    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

}