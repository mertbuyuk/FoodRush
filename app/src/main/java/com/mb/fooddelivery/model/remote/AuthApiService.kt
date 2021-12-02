package com.mb.fooddelivery.model.remote

import com.mb.fooddelivery.model.data.cart.CartResponse
import com.mb.fooddelivery.model.data.meals.MealList
import com.mb.fooddelivery.model.data.meals.details.MealDetailResponse
import com.mb.fooddelivery.model.data.restaurant.RestaurantListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthApiService {

    @GET("rest/restaurants")
    suspend fun getRestaurants() : Response<RestaurantListResponse>

    @GET("rest/restaurant/meals/{res_id}")
    suspend fun getRestaurantMeals(@Path("res_id") resId : Int) : Response<MealList>

    @GET("rest/meals/{meal_id}")
    suspend fun getMealDetail(@Path("meal_id") mealId : Int) : Response<MealDetailResponse>

    @PUT("rest/cart/add")
    suspend fun addToCart(@Query("meal_id") meal_id: Int, @Query("count") count: Int) : Response<CartResponse>

    @GET("rest/cart")
    suspend fun getCart() : Response<CartResponse>
}