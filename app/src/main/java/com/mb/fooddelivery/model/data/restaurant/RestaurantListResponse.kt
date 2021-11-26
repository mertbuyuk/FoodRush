package com.mb.fooddelivery.model.data.restaurant

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class RestaurantListResponse(
    @SerializedName("responseBody")
    val restaurantList: List<RestaurantProps>
)

@Parcelize
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
    @SerializedName("minDeliveryFee")
    val minDeliveryFee : String,
    @SerializedName("imageUrl")
    val imageUrl : String,

) : Parcelable
