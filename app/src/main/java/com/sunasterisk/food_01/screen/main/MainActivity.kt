package com.sunasterisk.food_01.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.screen.main.tabLayout.MainPageFragment
import com.sunasterisk.food_01.utils.addFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(MainPageFragment(), R.id.container)
    }
}
