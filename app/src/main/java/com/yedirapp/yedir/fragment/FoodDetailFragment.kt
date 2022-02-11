package com.yedirapp.yedir.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.FragmentFoodDetailPageBinding
import com.yedirapp.yedir.viewmodel.DetailPageViewModel


class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailPageBinding
    private lateinit var viewModel: DetailPageViewModel
    val username = "mehmet_saltan"
    val food_total = 2
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
        binding.detailPageObj = this
        return binding.root
    }

    fun onClickAddFood(
        food_name: String,
        food_image_name: String,
        food_price: Int,
        food_total: Int,
        username: String
    ) {
        viewModel.addFoodBasket(food_name, food_image_name, food_price, food_total, username)
    }

}