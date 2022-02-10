package com.yedirapp.yedir.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import com.yedirapp.yedir.R
import com.yedirapp.yedir.adapter.HomePageRvAdapter
import com.yedirapp.yedir.databinding.FragmentHomePageBinding
import com.yedirapp.yedir.viewmodel.HomePageViewModel

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var adapter: HomePageRvAdapter
    private lateinit var viewModel: HomePageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun onClick() {
        Log.e("Deneme2", "Denemeee")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        binding.homePageObj = this
        viewModel.foodsList.observe(viewLifecycleOwner, {
            adapter = HomePageRvAdapter(requireContext(), it, viewModel)
            binding.homePageRvAdapter = adapter

        })
        return binding.root
    }

}