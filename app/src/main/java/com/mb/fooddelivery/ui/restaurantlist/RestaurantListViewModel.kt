package com.mb.fooddelivery.ui.restaurantlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import com.mb.fooddelivery.model.data.restaurant.RestaurantListResponse
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantListViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel(){

    var restaurantList : List<RestaurantProps>? = null

    fun getAllRestaurants() : LiveData<Resource<RestaurantListResponse>> = apiRepository.getRestaurants()
}