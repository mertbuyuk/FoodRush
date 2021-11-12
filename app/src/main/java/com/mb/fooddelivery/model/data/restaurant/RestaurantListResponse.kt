package com.mb.fooddelivery.model.data.restaurant

import com.google.gson.annotations.SerializedName

data class RestaurantListResponse(
    @SerializedName("responseBody")
    val restaurantList: List<RestaurantProps>
)

data class RestaurantProps(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("cuisine")
    val cuisine : String,
    @SerializedName("information")
    val information : String,
    @SerializedName("minDeliveryTime")
    val minDeliveryTime : String,
    @SerializedName("id")
    val minDeliveryFee : String,
    @SerializedName("id")
    val imageUrl : String,

)
