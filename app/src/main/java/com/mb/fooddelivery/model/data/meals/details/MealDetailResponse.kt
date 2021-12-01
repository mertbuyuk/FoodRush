package com.mb.fooddelivery.model.data.meals.details

data class MealDetailResponse(
    val responseBody : DetailMeal
)


data class DetailMeal (
    val id : Int,

    val imageUrl : String,

    val name : String,

    val description : String,

    val price : Int,

    val ingredients : List<String>
)


