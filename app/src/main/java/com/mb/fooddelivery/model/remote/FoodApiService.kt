package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.model.data.login.LoginRequest
import com.mb.fooddelivery.model.data.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FoodApiService {

    @POST("public/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

}