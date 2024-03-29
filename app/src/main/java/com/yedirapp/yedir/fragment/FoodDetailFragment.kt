package com.yedirapp.yedir.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yedirapp.yedir.R

import com.yedirapp.yedir.databinding.FragmentFoodDetailPageBinding
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.viewmodel.DetailPageViewModel

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailPageBinding
    private lateinit var viewModel: DetailPageViewModel
    private lateinit var basketFoodsList: List<BasketFoods>
    val username = "mehmet_saltan"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailPageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail_page, container, false)
        val bundle: FoodDetailFragmentArgs by navArgs() //Detay sayfasına gelen yemeği
        binding.foodObj = bundle.food                   //bindingde bulunan yemeğe atadım
        binding.foodDescription = bundle.foodDescription
        binding.detailPageObj = this
        viewModel.basketFoodsList.observe(this,{
            basketFoodsList = it
        })
        viewModel.foodTotalResult.observe(this, {
            binding.foodTotal = it
        })
        viewModel.basketTotalResult.observe(this, {
            binding.basketTotal = it
        })
        return binding.root
    }
   //Artırma fonksiyonum
    fun onClickIncrease(
        food_total: String,
        food_price: Int,
        basket_total: Int
    ) {
        viewModel.increase(food_total, food_price, basket_total)

    }
    //Azaltma fonksiyonum
    fun onClickDecrease(
        food_total: String,
        food_price: Int,
        basket_total: Int
    ) {
        viewModel.decrease(food_total, food_price, basket_total)

    }
    //Yemek ekleme fonksiyonum
    fun clickAddFood(
        food_name: String,
        food_image_name: String,
        food_price: Int,
        food_total: Int,
        username: String
    ) {
        /* Apilerden kaynaklanan sorun nedeniyle bir yemeğin iki kere sepete ekleyince sepette yemeğin adeti
          güncellenemediğinden aynı yemekten iki adet card oluşuyordu ben de alttaki geliştirdiğim algoritmayla
          sepette bulunan yemeğin adetini bir değişkende tutup sepette var olan yemeği sildim daha sonra
          eklenecek adetle tuttuğum değişkeni bir biriyle toplayarak bir nevi güncelleme işlemi yaptım.
          */
        var basketTotal= 0
        var foodTotal=food_total
        basketFoodsList.listIterator().forEach {
            if (it.food_image_name == food_image_name) {
                basketTotal = it.food_total
                viewModel.deleteFoodBasket(it.basket_food_id, username)
                foodTotal = basketTotal + food_total
            }
        }
        viewModel.addFoodBasket(food_name, food_image_name, food_price, foodTotal, username)

        Toast.makeText(
            this.requireContext(), "${"$food_total Adet ${food_name} sepete eklendi"}",
            Toast.LENGTH_LONG
        ).show()

    }

}