package com.mb.fooddelivery.utils

import android.util.Log
import retrofit2.Response

abstract class BaseDataSource {
    suspend fun <T> getResult(call : suspend() -> Response<T> ) : Resource<T>{
        val response  = call()
        if (response.isSuccessful){
            val body = response.body()
            if (body != null){
                return Resource.success(body)
            }
        }

        val errorBody = response.errorBody().toString()
        return error("${response.code()} - $errorBody")
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network error: $message")
    }
}