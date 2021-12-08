package com.mb.fooddelivery.ui.restaurantlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentRestaurantListBinding
import com.mb.fooddelivery.model.data.categories.CategoriesCuisine
import com.mb.fooddelivery.model.data.categories.getCuisineList
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps
import com.mb.fooddelivery.ui.categories.CategoriesListAdapter
import com.mb.fooddelivery.ui.categories.ICategoryOnClick
import com.mb.fooddelivery.ui.viewpager.ViewPagerAdapter
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantListFragment : Fragment() {
    private lateinit var binding  : FragmentRestaurantListBinding
    private val viewModel : RestaurantListViewModel by viewModels()

    private var categoryList : MutableList<CategoriesCuisine> = mutableListOf()
    private val restaurantAdapter = RestaurantListAdapter()
    private val categoryAdapter = CategoriesListAdapter()
    private val sliderAdapter = ViewPagerAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurantListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerRestaurants.adapter = restaurantAdapter
        binding.recyclerCategories.adapter = categoryAdapter

        initViewPager()
        getRestaurantList()
        getCategories()
        initClickListeners()

        binding.searchView.setOnClickListener {
            val action = RestaurantListFragmentDirections.actionRestaurantListFragmentToRestaurantSearchFragment(viewModel.restaurantList!!.toTypedArray())
            findNavController().navigate(action)
        }
    }

    private fun initClickListeners() {
        restaurantAdapter.addListener(object : IOnClick{
            override fun onClick(item: RestaurantProps) {
                val action = RestaurantListFragmentDirections.actionRestaurantListFragmentToRestaurantMealFragment(item)
                findNavController().navigate(action)
            }
        })

        categoryAdapter.addListener(object  : ICategoryOnClick{
            override fun onClick(category: CategoriesCuisine) {
                //TODO
            }

        })
    }

    private fun initViewPager() {
        var list = mutableListOf<Int>()
        list.add(R.drawable.burgerking_image)
        list.add(R.drawable.dominos_image)
        list.add(R.drawable.mcdonalds_image)

        sliderAdapter.setContentList(list)
        binding.viewPager2.adapter = sliderAdapter

    }

    private fun getCategories() {
        categoryList = getCuisineList()
        categoryAdapter.submitList(categoryList)
    }

    private fun getRestaurantList() {
        viewModel.getAllRestaurants().observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.SUCCESS -> onSucces(it.data?.restaurantList)
            }
        })
    }

    private fun onSucces(restaurantList: List<RestaurantProps>?) {
        restaurantAdapter.submitList(restaurantList)
        viewModel.restaurantList = restaurantList
    }


}