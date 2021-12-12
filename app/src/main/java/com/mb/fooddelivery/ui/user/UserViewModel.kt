package com.mb.fooddelivery.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.user.UserRequest
import com.mb.fooddelivery.model.data.user.UserResponse
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun getUser() : LiveData<Resource<UserResponse>> = apiRepository.getUser()

    fun editUserSettings(userRequest: UserRequest): LiveData<Resource<UserResponse>> = apiRepository.updateUser(userRequest)
}