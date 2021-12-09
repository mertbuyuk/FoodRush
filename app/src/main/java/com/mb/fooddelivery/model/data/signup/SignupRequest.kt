package com.mb.fooddelivery.model.data.signup

import com.google.gson.annotations.SerializedName

data class SignupRequest (
    val name: String,
    val surname: String,
    val username: String,
    val email: String,
    val password: String)