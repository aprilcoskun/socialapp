package com.jupiter.socialapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jupiter.socialapp.databinding.ActivityMainBinding
import com.jupiter.socialapp.utils.BottomNavService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bottomNavService = BottomNavService.getInstance(supportFragmentManager)
    }
}