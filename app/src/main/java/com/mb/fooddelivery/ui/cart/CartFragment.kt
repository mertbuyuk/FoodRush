package com.mb.fooddelivery.ui.cart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.mb.fooddelivery.databinding.FragmentCartBinding
import com.mb.fooddelivery.model.data.cart.RestaurantInfo
import com.mb.fooddelivery.utils.Resource
import com.mb.fooddelivery.utils.SwipetoDelete
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    private val viewModel : CartViewModel by viewModels()
    private val adapter = CartAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewCart.adapter = adapter
        getCart()
        swipetoDelete()
    }

    private fun swipetoDelete() {
        val swipetoDelete = object  : SwipetoDelete(requireContext()){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.removeItem(viewHolder.adapterPosition)
            }
        }
        val touchHelper = ItemTouchHelper(swipetoDelete)
        touchHelper.attachToRecyclerView(binding.recyclerViewCart)

    }

    private fun getCart() {
        viewModel.getCart().observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.SUCCESS -> onSucces(it.data!!.responseBody)
            }
        })
    }

    private fun onSucces(responseBody: RestaurantInfo) {
        Log.i("Mert", responseBody.toString())
        adapter.submitList(responseBody.mealInfoList)

    }
}