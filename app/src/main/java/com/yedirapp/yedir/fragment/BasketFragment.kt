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
            binding.totalBasketPrice = basketFoodsTotalPrice.toString()
            adapter = BasketPageRvAdapter(requireContext(), it, viewModel)
            binding.BasketPageRv.adapter = adapter
        })
        return binding.root
    }

}