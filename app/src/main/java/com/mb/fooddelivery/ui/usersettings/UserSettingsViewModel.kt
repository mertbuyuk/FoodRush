package com.mb.fooddelivery.ui.usersettings

import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.user.UserRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserSettingsViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun editUserSettings(userRequest: UserRequest) = apiRepository.updateUser(userRequest)
}