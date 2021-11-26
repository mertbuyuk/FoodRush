package com.mb.fooddelivery.ui.restaurantmeals

import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor( private val apiRepository: ApiRepository) : ViewModel() {

    fun getMeals(id : Int) = apiRepository.getRestaurantMeals(id)
}