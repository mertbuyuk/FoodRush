package com.mb.fooddelivery.model.local

import javax.inject.Inject

class LocalDataSource @Inject constructor(private val sharedPref: SharedPref) {
    fun saveToken(token : String){
        sharedPref.saveToken(token)
    }

    fun getToken(): String? {
        return sharedPref.getToken()
    }
}