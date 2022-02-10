package com.yedirapp.yedir.onboarding.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {

    private lateinit var binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_third_screen, container, false)
        binding.thirdScreenObj=this
       /* binding.txtNext.setOnClickListener {
            findNavController().navigate(R.id.viewPagerToHomePage)
        }*/

        return binding.root

    }
    fun onClickFinish() {
        Log.e("Deneme","Deneme")
    }
}