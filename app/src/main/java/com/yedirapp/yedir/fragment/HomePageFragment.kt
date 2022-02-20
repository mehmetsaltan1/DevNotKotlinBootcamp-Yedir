package com.yedirapp.yedir.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yedirapp.yedir.R
import com.yedirapp.yedir.adapter.HomePageRvAdapter
import com.yedirapp.yedir.databinding.FragmentHomePageBinding
import com.yedirapp.yedir.entity.BasketFoods
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.viewmodel.HomePageViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var adapter: HomePageRvAdapter
    private lateinit var viewModel: HomePageViewModel
    private lateinit var foodList: List<Foods>
    private lateinit var basketFoodsList: List<BasketFoods>
    val userName = "mehmet_saltan"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }
   //Fab butonu aracılığıyla anasayfadan sepet sayfasına geçiş fonksiyonum
    fun onClickFab() {
        findNavController().navigate(R.id.homePageToBasketPage)
    }
     override fun onResume() {
          super.onResume()
          viewModel.loadBasketFoods(userName)
      }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        binding.homePageObj = this
        viewModel.basketFoodsList.observe(viewLifecycleOwner, {
            basketFoodsList = it
        })
        viewModel.foodsList.observe(viewLifecycleOwner, {
            foodList = it
            viewModel.foodsDescriptionList.observe(viewLifecycleOwner) {
                //View modelimden aldığım her iki listemi de verileri kullanacağım yer olan RecyclerViewAdapter'ıma gönderdim
                adapter = HomePageRvAdapter(
                    requireContext(), foodList,
                    it, viewModel, layoutInflater, basketFoodsList,viewLifecycleOwner
                )
                binding.homePageRvAdapter = adapter
            }


        })
        return binding.root
    }

}