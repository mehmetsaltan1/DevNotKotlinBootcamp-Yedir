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
import com.yedirapp.yedir.datastore.AppPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThirdScreen : Fragment() {
    private lateinit var binding: FragmentThirdScreenBinding
    private lateinit var ap: AppPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ap = AppPref(requireContext())

    }

    fun onClickFinish() {
        /* Bu fonksiyonum sayesinde eğer kullanıcı onboard ekranının son ekranına gelip bitir butonana basarsa
        data store'uma yazma işlemini başlatıyorum bu yazma işlemi zaman alacağı için corutine yapısından yararlanıp
        ekranı bu yazma işlemi gerçekleşene kadar bekletiyorum.
        */
        val job = CoroutineScope(Dispatchers.Main).launch {
            ap.setPref(true)
        }
        findNavController().navigate(R.id.viewPagerToHomePage)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_third_screen, container, false)
        binding.thirdScreenObj = this
        return binding.root

    }


}