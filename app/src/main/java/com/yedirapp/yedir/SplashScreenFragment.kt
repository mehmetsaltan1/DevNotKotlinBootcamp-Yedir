package com.yedirapp.yedir

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yedirapp.yedir.datastore.AppPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment() {

    private lateinit var ap: AppPref
    private var result: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ap = AppPref(requireContext())
        val job = CoroutineScope(Dispatchers.Main).launch {
            result = ap.getPref()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({
            Log.e("pref", "$result")
            if (result) {
                findNavController().navigate(R.id.splashToHomePage)
            } else {
                findNavController().navigate(R.id.splashToViewPager)
            }
        }, 2000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }


}