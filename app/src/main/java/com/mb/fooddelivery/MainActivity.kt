package com.mb.fooddelivery

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mb.fooddelivery.databinding.ActivityMainBinding
import com.mb.fooddelivery.utils.setStatusBarTransparent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNav = findViewById(R.id.bottomNavigationView)
        initBottomNavs()
        setStatusBarTransparent(this,binding.root)
    }


    private fun initBottomNavs() {
        bottomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.cart -> {
                    Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.action_to_cart)
                }
                R.id.profile->{
                    Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.global_user)
                }
                R.id.home -> {
                    Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.global_home)
                }
            }
            true
        }
    }
}