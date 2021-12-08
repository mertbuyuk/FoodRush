package com.mb.fooddelivery.model.data.user

data class UserResponse(
    val responseBody : UserBody
)

data class UserBody(
    val name : String,
    val surname : String,
    val email :  String,
    val username : String,
    val password :  String,
    val address : String,
    val phone : String
)
