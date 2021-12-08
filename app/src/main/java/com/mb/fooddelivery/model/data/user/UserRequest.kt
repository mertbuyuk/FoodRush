package com.mb.fooddelivery.model.data.user

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("phone")
    val phone: String
)