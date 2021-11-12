package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.model.data.login.LoginRequest
import com.mb.fooddelivery.utils.BaseDataSource
import javax.inject.Inject


class RemoteDataSource @Inject constructor (private val apiService: FoodApiService)  : BaseDataSource(){
    suspend fun loginRequest(request: LoginRequest) = getResult {
        apiService.login(request)
    }
}