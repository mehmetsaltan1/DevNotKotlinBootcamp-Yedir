package com.yedirapp.yedir.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.HomePageCardDesignBinding
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.entity.FoodsDescription
import com.yedirapp.yedir.fragment.HomePageFragment
import com.yedirapp.yedir.fragment.HomePageFragmentDirections
import com.yedirapp.yedir.viewmodel.HomePageViewModel

class HomePageRvAdapter(
    var mContext: Context,
    var foodsList: List<Foods>,
    var foodsDescriptionList: List<FoodsDescription>,
    var viewModel: HomePageViewModel,
    var layoutInflater: LayoutInflater,
    var basketFoodsList: List<BasketFoods>,
    var viewLifecycleOwner: LifecycleOwner
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
        val foodDesc = foodsDescriptionList.get(position)


        val t = holder.cardDesignBinding
        t.foodObj = food
        t.cardView.setOnClickListener {
            // Nav Args yardımıyla her card'a tıklanınca detay sayfasına o kartta bulunan yemeği gönderdim
            val intent = HomePageFragmentDirections.homePageToDetailPage(food, foodDesc)
            Navigation.findNavController(it).navigate(intent)
        }
        t.btnAddBasketFood.setOnClickListener {
            /* Apilerden kaynaklanan sorun nedeniyle bir yemeğin iki kere sepete ekleyince sepette yemeğin adeti
            güncellenemediğinden aynı yemekten iki adet card oluşuyordu ben de alttaki geliştirdiğim algoritmayla
            sepette bulunan yemeğin adetini bir değişkende tutup sepette var olan yemeği sildim daha sonra
            eklenecek adetle tuttuğum değişkeni bir biriyle toplayarak bir nevi güncelleme işlemi yaptım.
            */
            viewModel.basketFoodsList.observe(viewLifecycleOwner, {
                basketFoodsList = it
            })
            viewModel.loadBasketFoods(viewModel.username)
            val designAlertlayout =
                layoutInflater.inflate(R.layout.custom_alert_dialog_design, null)
            val editTextAlert = designAlertlayout.findViewById(R.id.customInputText) as EditText

            MaterialAlertDialogBuilder(mContext, R.style.MaterialAlertDialog_rounded)
                .setView(designAlertlayout)
                .setPositiveButton("Ekle") { dialog, which ->
                    var basketTotal = 0
                    var food_total = editTextAlert.text.toString().toInt()
                    basketFoodsList.listIterator().forEach {
                        if (it.food_image_name == food.food_image_name) {
                            basketTotal = it.food_total
                            viewModel.deleteFoodBasket(it.basket_food_id, viewModel.username)
                            food_total = basketTotal + food_total
                        }
                    }
                    Toast.makeText(
                        mContext,
                        "${(food_total - basketTotal)} Adet ${food.food_name} sepete eklendi",
                        Toast.LENGTH_LONG
                    ).show()
                    viewModel.addFoodBasket(
                        food.food_name,
                        food.food_image_name,
                        food.food_price,
                        food_total,
                        viewModel.username
                    )

                }
                .setNegativeButton("İptal") { dialog, which ->
                }
                .create()
                .show()
        }

    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

}