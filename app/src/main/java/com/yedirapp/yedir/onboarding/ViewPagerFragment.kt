package com.yedirapp.yedir.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yedirapp.yedir.R
import com.yedirapp.yedir.adapter.ViewPagerAdapter
import com.yedirapp.yedir.databinding.FragmentViewPagerBinding
import com.yedirapp.yedir.viewmodel.ViewPagerViewModel

class ViewPagerFragment : Fragment() {
    private lateinit var binding:FragmentViewPagerBinding
    private lateinit var viewModel : ViewPagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ViewPagerViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentList = viewModel.fragmentList
        val adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
      /*  Üstte oluşturduğum fragmentList'e viewmodelden aldığım fragment listesini atayıp ViewPagerAdapter
        sınıfından bir adapter nesnesi oluşturup içerisine hem listeyi hem bulunduğum fragment'i hem de
        lifecycle ı atadım.*/
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false)
        binding.viewpager.adapter = adapter // Burada da oluşturduğum adapter'ı view pager'ın adapterına atadım

        return binding.root

    }

}