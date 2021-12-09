package com.mb.fooddelivery.model.data.signup

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("responseBody")
    val registerData: RegisterBody,
)

data class RegisterBody(
    val jwtToken: String
)
