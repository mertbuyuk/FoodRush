package com.mb.fooddelivery.ui.cart

import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(val apiRepository: ApiRepository) : ViewModel(){

    fun getCart() = apiRepository.getCart()
}