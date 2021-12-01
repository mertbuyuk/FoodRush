package com.mb.fooddelivery.ui.restaurantmeals

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mb.fooddelivery.databinding.FragmentRestaurantMealBinding
import com.mb.fooddelivery.model.data.meals.MealProps
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantMealFragment : Fragment() {
    private lateinit var binding : FragmentRestaurantMealBinding
    private val adapter = MealListAdapter()
    private val viewModel : MealsViewModel by viewModels()
    private val args : RestaurantMealFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurantMealBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mealRecycler.adapter = adapter

        getMeals()
        clickListeners()
        fillRestİnfos()


    }

    private fun fillRestİnfos() {
        binding.apply {
            Glide.with(root)
                .load(args.restaurantProps?.imageUrl)
                .fitCenter()
                .into(imgRestaurant)

            txtRestaurantName.text = args.restaurantProps?.name
        }
    }

    private fun clickListeners() {
        adapter.addListener(object : IMealOnClick{
            override fun mealClick(meal: MealProps) {
                val action = RestaurantMealFragmentDirections.actionRestaurantMealFragmentToMealDetailsFragment(meal.id,args.restaurantProps!!)
                findNavController().navigate(action)
            }

        })
    }

    private fun getMeals(){
        viewModel.getMeals(args.restaurantProps!!.id).observe(viewLifecycleOwner,
            {
                when(it.status){
                    Resource.Status.SUCCESS -> onSucces(it.data?.mealList)
                }
            })
    }

    private fun onSucces(mealList: List<MealProps>?) {
        adapter.submitList(mealList)
    }


}