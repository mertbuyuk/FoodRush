package com.mb.fooddelivery.ui.mealdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.cart.CartResponse
import com.mb.fooddelivery.model.data.meals.MealProps
import com.mb.fooddelivery.model.data.meals.details.MealDetailResponse
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor (private val apiRepository: ApiRepository) : ViewModel() {

    fun getMealDetail(id : Int)  : LiveData<Resource<MealDetailResponse>> = apiRepository.getMealDetail(id)

    fun addToCart(id: Int, count : Int) : LiveData<Resource<CartResponse>>  = apiRepository.addToCart(id,count)
}