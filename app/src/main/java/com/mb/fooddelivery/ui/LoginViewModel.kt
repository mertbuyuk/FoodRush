package com.mb.fooddelivery.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.login.LoginRequest
import com.mb.fooddelivery.model.data.login.LoginResponse
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel(){

    fun login(email : String, password : String): LiveData<Resource<LoginResponse>>{
        val request = LoginRequest(email,password)
        return apiRepository.login(request)
    }
}