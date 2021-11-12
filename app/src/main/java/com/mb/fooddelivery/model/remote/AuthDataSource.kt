package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.utils.BaseDataSource
import javax.inject.Inject

class AuthDataSource @Inject constructor(private val apiService: AuthApiService) : BaseDataSource(){

    suspend fun getRestaurants() = getResult {apiService.getRestaurants()}
}