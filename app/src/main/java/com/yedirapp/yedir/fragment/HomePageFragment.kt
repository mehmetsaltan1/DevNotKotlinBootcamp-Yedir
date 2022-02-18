package com.yedirapp.yedir.fragment

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yedirapp.yedir.R
import com.yedirapp.yedir.adapter.HomePageRvAdapter
import com.yedirapp.yedir.databinding.FragmentHomePageBinding
import com.yedirapp.yedir.entity.Foods
import com.yedirapp.yedir.viewmodel.HomePageViewModel

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var adapter: HomePageRvAdapter
    private lateinit var viewModel: HomePageViewModel
    private var food_total: Int = 1
    val userName = "mehmet_saltan"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun onClickFab() {
        findNavController().navigate(R.id.homePageToBasketPage)
    }

    fun onClickAddFood(
        foodObj: Foods,
        username: String
    ) {
        val designAlertlayout = layoutInflater.inflate(R.layout.custom_alert_dialog_design, null)
        val editTextAlert = designAlertlayout.findViewById(R.id.customInputText) as EditText
        MaterialAlertDialogBuilder(requireActivity(), R.style.MaterialAlertDialog_rounded)
            .setView(designAlertlayout)
            .setPositiveButton("Ekle") { dialog, which ->
                food_total = editTextAlert.text.toString().toInt()
                viewModel.addFoodBasket(
                    foodObj.food_name,
                    foodObj.food_image_name,
                    foodObj.food_price,
                    food_total,
                    username
                )
                Toast.makeText(this.requireContext(),"${"$food_total Adet ${foodObj.food_name} sepete eklendi"}",Toast.LENGTH_LONG).show()
              //  myToast.show()
            }
            .setNegativeButton("İptal", null)
            .create()
            .show()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        binding.homePageObj = this

        viewModel.foodsList.observe(viewLifecycleOwner, {
            var foodList = it
            viewModel.foodsDescriptionList.observe(viewLifecycleOwner) {
                adapter = HomePageRvAdapter(
                    requireContext(), foodList,
                    it, this
                )
                binding.homePageRvAdapter = adapter
            }


        })
        return binding.root
    }

}