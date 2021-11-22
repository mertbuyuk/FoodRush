package com.mb.fooddelivery.ui.restaurantlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mb.fooddelivery.databinding.ItemRestaurantsBinding
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps

class RestaurantListAdapter : ListAdapter<RestaurantProps, RestaurantListAdapter.RestaurantViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {

        val binding = ItemRestaurantsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantViewHolder(binding)
    }

    class RestaurantViewHolder(private val binding: ItemRestaurantsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant : RestaurantProps){
            binding.itemRestaurantsName.text = restaurant.name
            binding.itemRestaurantsLoc.text = restaurant.cuisine

            Glide.with(binding.root)
                .load(restaurant.imageUrl)
                .into(binding.itemRestaurantsPhoto)
        }
    }


    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RestaurantProps>() {
            override fun areItemsTheSame(oldItem: RestaurantProps, newItem: RestaurantProps) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: RestaurantProps, newItem: RestaurantProps) =
                oldItem == newItem
        }
    }
}