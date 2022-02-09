package com.yedirapp.yedir.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.yedirapp.yedir.R
import com.yedirapp.yedir.databinding.FragmentSecondScreenBinding
import com.yedirapp.yedir.onboarding.ViewPagerFragment

class SecondScreen : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding
    val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_second_screen, container, false)

        return binding.root
    }
    fun onClickNext(){
        viewPager!!.currentItem = 2
    }


}