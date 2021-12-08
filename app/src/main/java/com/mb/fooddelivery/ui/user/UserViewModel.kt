package com.mb.fooddelivery.ui.user

import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun getUser() = apiRepository.getUser()
}