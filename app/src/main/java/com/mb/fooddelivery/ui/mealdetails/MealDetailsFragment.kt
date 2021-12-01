package com.mb.fooddelivery.ui.mealdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentMealDetailsBinding
import com.mb.fooddelivery.model.data.meals.details.DetailMeal
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private lateinit var binding : FragmentMealDetailsBinding
    private val viewModel : MealDetailViewModel by viewModels()
    val navArgs : MealDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMealDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMealDetails()
    }

    private fun getMealDetails() {

        viewModel.getMealDetail(navArgs.mealId).observe(viewLifecycleOwner,{

            when(it.status){
                Resource.Status.SUCCESS -> onSucces(it.data?.responseBody)
            }
        })
    }

    private fun onSucces(responseBody: DetailMeal?) {

        binding.apply {
            Glide.with(binding.root)
                .load(responseBody?.imageUrl)
                .centerInside()
                .into(imgMealDetail)

            txtMealNameDetail.text = responseBody?.name
            txtMealDetailDesc.text = responseBody?.description
            txtMealDetailPrice.text = responseBody?.price.toString()
        }
        Log.i("Mert",responseBody.toString())
    }
}