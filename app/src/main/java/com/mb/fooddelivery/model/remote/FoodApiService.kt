package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.model.data.login.LoginRequest
import com.mb.fooddelivery.model.data.login.LoginResponse
import com.mb.fooddelivery.model.data.signup.SignupRequest
import com.mb.fooddelivery.model.data.signup.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FoodApiService {

    @POST("public/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>


    @POST("public/register")
    suspend fun register(@Body request: SignupRequest): Response<SignupResponse>

}