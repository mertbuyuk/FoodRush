package com.mb.fooddelivery.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mb.fooddelivery.model.data.login.LoginResponse
import kotlinx.coroutines.Dispatchers

fun <T> networkOperation(call : suspend() -> Resource<T>,saveToken: (token : String) -> Unit) : LiveData<Resource<T>>{
    return liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val networkCall = call.invoke()
        if (networkCall.status == Resource.Status.SUCCESS){
            val data = networkCall.data!!

            if (data is LoginResponse){
                saveToken(data.responseBody.jwtToken)
            }
            emit(Resource.success(data))
        }
        else if (networkCall.status == Resource.Status.ERROR){
            emit(
                Resource.error("Error ${networkCall.message}")
            )
        }
    }
}