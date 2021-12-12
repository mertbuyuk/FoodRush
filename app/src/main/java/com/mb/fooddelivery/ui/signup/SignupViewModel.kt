package com.mb.fooddelivery.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.signup.SignupRequest
import com.mb.fooddelivery.model.data.signup.SignupResponse
import com.mb.fooddelivery.model.data.user.UserRequest
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private  val apiRepository: ApiRepository) : ViewModel(){

    fun signup(signupRequest: SignupRequest) : LiveData<Resource<SignupResponse>> = apiRepository.signup(signupRequest)
}