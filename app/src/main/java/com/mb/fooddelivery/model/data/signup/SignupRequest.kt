package com.mb.fooddelivery.model.data.signup

import com.google.gson.annotations.SerializedName

data class SignupRequest (
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
    )