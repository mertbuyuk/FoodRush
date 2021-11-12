package com.mb.fooddelivery.model.data.login

data class LoginResponse(
    val message : String,
    val responseBody : RespBody
)

data class RespBody (
    val jwtToken : String)
