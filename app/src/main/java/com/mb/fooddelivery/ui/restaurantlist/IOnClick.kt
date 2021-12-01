package com.mb.fooddelivery.ui.restaurantlist

import com.mb.fooddelivery.model.data.restaurant.RestaurantProps
import com.mb.fooddelivery.ui.restaurantmeals.IMealOnClick

interface IOnClick{

    fun onClick(item : RestaurantProps)
}