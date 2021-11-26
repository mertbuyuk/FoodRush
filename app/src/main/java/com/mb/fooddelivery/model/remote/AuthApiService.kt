package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.model.data.meals.MealList
import com.mb.fooddelivery.model.data.restaurant.RestaurantListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApiService {

    @GET("rest/restaurants")
    suspend fun getRestaurants() : Response<RestaurantListResponse>

    @GET("rest/restaurant/meals/{res_id}")
    suspend fun getRestaurantMeals(@Path("res_id") resId : Int) : Response<MealList>
}