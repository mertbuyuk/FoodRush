package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.model.data.restaurant.RestaurantListResponse
import retrofit2.Response
import retrofit2.http.GET

interface AuthApiService {

    @GET("rest/restaurants")
    suspend fun getRestaurants() : Response<RestaurantListResponse>
}