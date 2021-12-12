package com.mb.fooddelivery.ui.splash

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.ActivitySplashBinding
import com.mb.fooddelivery.utils.setStatusBarTransparent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStatusBarTransparent(this,binding.root)
    }
}