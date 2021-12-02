package com.mb.fooddelivery.model.data.cart

import com.google.gson.annotations.SerializedName
import com.mb.fooddelivery.model.data.meals.MealProps
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps

data class CartResponse(

    val responseBody : RestaurantInfo
)

data class RestaurantInfo(

    @SerializedName("restaurantInfo")
    val restaurantInfo: RestaurantProps,

    val mealInfoList : List<MealInfo>,
)

data class MealInfo(

    var count: Int,

    val mealInfo: MealProps
)
