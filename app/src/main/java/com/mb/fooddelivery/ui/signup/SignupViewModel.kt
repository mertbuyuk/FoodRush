package com.mb.fooddelivery.ui.signup

import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.signup.SignupRequest
import com.mb.fooddelivery.model.data.user.UserRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private  val apiRepository: ApiRepository) : ViewModel(){

    fun signup(signupRequest: SignupRequest) = apiRepository.signup(signupRequest)
}