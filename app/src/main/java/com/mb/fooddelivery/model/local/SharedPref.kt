package com.mb.fooddelivery.model.local

import android.content.Context
import android.content.SharedPreferences
import com.mb.fooddelivery.utils.Constant
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPref @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences : SharedPreferences =
        context.getSharedPreferences(Constant.FILE_NAME,Context.MODE_PRIVATE)

    fun saveToken(token : String) {
        sharedPreferences.edit().putString(Constant.TOKEN,token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(Constant.TOKEN, "")
    }
}
