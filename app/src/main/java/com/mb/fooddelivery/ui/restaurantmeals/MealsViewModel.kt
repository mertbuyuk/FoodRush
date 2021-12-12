package com.mb.fooddelivery.ui.restaurantmeals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.meals.MealList
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor( private val apiRepository: ApiRepository) : ViewModel() {

    fun getMeals(id : Int) : LiveData<Resource<MealList>> = apiRepository.getRestaurantMeals(id)
}