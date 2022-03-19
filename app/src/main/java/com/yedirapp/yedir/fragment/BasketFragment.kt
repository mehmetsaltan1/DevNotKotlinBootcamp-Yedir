package com.yedirapp.yedir.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yedirapp.yedir.R
import com.yedirapp.yedir.adapter.BasketPageRvAdapter
import com.yedirapp.yedir.adapter.HomePageRvAdapter
import com.yedirapp.yedir.databinding.FragmentBasketPageBinding
import com.yedirapp.yedir.databinding.FragmentHomePageBinding
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.viewmodel.BasketPageViewModel
import com.yedirapp.yedir.viewmodel.HomePageViewModel
import java.lang.Exception

class BasketFragment : Fragment() {

    private lateinit var binding: FragmentBasketPageBinding
    private lateinit var adapter: BasketPageRvAdapter
    private lateinit var viewModel: BasketPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: BasketPageViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun startAnimation(){
        binding.animationView.playAnimation()
    }
    fun stopAnimation(){
        binding.animationView.cancelAnimation()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket_page, container, false)
        binding.basketPageObj = this
        viewModel.basketFoodsList.observe(viewLifecycleOwner, {
            var basketFoodsTotalPrice = 0
            it.listIterator().forEach {
                basketFoodsTotalPrice += it.food_price * it.food_total
            }
            /*Üstte yaptığım algoritma sayesinde liste elemanlarımı tek tek gezip içerisinde bulunan
            fiyatları bir değişkende toplayıp toplam sepet tutarımı bulup aşağıda yer alan işlemle ekrana gönderdim.
            */
            binding.totalBasketPrice = basketFoodsTotalPrice.toString()
            adapter = BasketPageRvAdapter(requireContext(), it, viewModel)
            binding.basketRvObj = adapter
            binding.BasketPageRv.adapter = adapter
            if (basketFoodsTotalPrice == 0){
                startAnimation()
            }
            else {
                stopAnimation()
            }
        })
        return binding.root
    }

}