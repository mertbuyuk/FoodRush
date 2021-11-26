package com.mb.fooddelivery.model.data.meals

import com.google.gson.annotations.SerializedName

data class MealList(
    @SerializedName("responseBody")
    val mealList: List<MealProps>
)

data class MealProps(
    @SerializedName("id")
    val id :Int,
    @SerializedName("imageUrl")
    val imageUrl : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("description")
    val desc : String,
    @SerializedName("price")
    val price : Int,
    @SerializedName("ingredients")
    val ingredients : List<String>
)



