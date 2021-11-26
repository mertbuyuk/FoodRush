package com.mb.fooddelivery.ui.mainpage.restaurantlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentRestaurantSearchBinding
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class RestaurantSearchFragment : Fragment() {
    private lateinit var binding : FragmentRestaurantSearchBinding
    private val args: RestaurantSearchFragmentArgs by navArgs()
    private val restaurantAdapter = SearchFilterAdapter()
    private lateinit var restaurantList : MutableList<RestaurantProps>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurantSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurantList = args.restaurantProps.toMutableList()
        binding.vertRecyclerRest.adapter = restaurantAdapter
        restaurantAdapter.submitList(restaurantList)

        binding.searchRest.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {

                searchEvent(query)
                return true
            }

        })
    }

    private fun searchEvent(text: String) {
         if (text.isNullOrEmpty()){
             restaurantAdapter.submitList(restaurantList)
             return
         }
        val filterList : MutableList<RestaurantProps> = mutableListOf()

        restaurantList?.forEach {
            if (it.name.lowercase().contains(text.lowercase().trim())){
                filterList.add(it)
            }}
        restaurantAdapter.submitList(filterList)
    }

}