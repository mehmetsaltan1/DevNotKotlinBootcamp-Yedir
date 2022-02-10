package com.yedirapp.yedir.onboarding.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.FragmentSecondScreenBinding
import com.yedirapp.yedir.databinding.FragmentViewPagerBinding
import com.yedirapp.yedir.onboarding.ViewPagerFragment

class SecondScreen : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding
    private lateinit var viewPager2: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        viewPager2 = viewPager!!
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_second_screen, container, false)
        binding.secondScreenObj = this
        return binding.root
    }

    fun onClickNext() {
        viewPager2.currentItem = 2
    }

}