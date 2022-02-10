package com.yedirapp.yedir.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.FragmentFoodDetailPageBinding


class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail_page, container, false)
        val bundle: FoodDetailFragmentArgs by navArgs()
        binding.foodObj = bundle.food

        return  binding.root
    }

}