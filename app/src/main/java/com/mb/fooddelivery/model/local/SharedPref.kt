package com.mb.fooddelivery.model.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPref @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences : SharedPreferences =
        context.getSharedPreferences("foodSharedPref",Context.MODE_PRIVATE)

    fun saveToken(token : String) {
        sharedPreferences.edit().putString("token",token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", "")
    }
}
