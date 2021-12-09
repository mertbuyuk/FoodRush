package com.mb.fooddelivery.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.cart.CartResponse
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(val apiRepository: ApiRepository) : ViewModel(){

    fun getCart() : LiveData<Resource<CartResponse>> = apiRepository.getCart()
}