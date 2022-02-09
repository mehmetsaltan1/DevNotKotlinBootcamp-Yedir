package com.yedirapp.yedir.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.yedirapp.yedir.onboarding.screens.FirstScreen
import com.yedirapp.yedir.onboarding.screens.SecondScreen
import com.yedirapp.yedir.onboarding.screens.ThirdScreen

class ViewPagerViewModel:ViewModel() {
     val fragmentList = arrayListOf<Fragment>(
        FirstScreen(),
        SecondScreen(),
        ThirdScreen()
    )

}