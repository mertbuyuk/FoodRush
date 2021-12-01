package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.utils.BaseDataSource
import javax.inject.Inject

class AuthDataSource @Inject constructor(private val apiService: AuthApiService) : BaseDataSource(){

    suspend fun getRestaurants() = getResult {apiService.getRestaurants()}

    suspend fun getRestaurantMeals(id : Int) = getResult {
        apiService.getRestaurantMeals(id)
    }

    suspend fun getMealDetail(id : Int) = getResult {
        apiService.getMealDetail(id)
    }

    suspend fun addToCart(id: Int,count : Int) = getResult {
        apiService.addToCart(id,count)
    }
}