package com.mb.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNavigationView)

        initBottomNavs()
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