package com.mb.fooddelivery.ui.mealdetails

import androidx.lifecycle.ViewModel
import com.mb.fooddelivery.model.ApiRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor (private val apiRepository: ApiRepository) : ViewModel() {

    fun getMealDetail(id : Int) = apiRepository.getMealDetail(id)
}