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
    private var result: Boolean = false
    private lateinit var ap: AppPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ap = AppPref(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({
            Log.e("pref", "${onBoardingFinished()}")
            if (onBoardingFinished()) {
                findNavController().navigate(R.id.splashToHomePage)
            } else {
                findNavController().navigate(R.id.splashToViewPager)
            }

        }, 2000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    private fun onBoardingFinished(): Boolean {
        val job = CoroutineScope(Dispatchers.Main).launch {
            result = ap.getPref()
            Log.e("pref3", "$result")
        }
        return result

    }


}