package com.mb.fooddelivery.ui.restaurantlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mb.fooddelivery.databinding.VerticalRestaurantItemBinding
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps

class SearchFilterAdapter : ListAdapter<RestaurantProps, SearchFilterAdapter.RestaurantViewHolder>(DIFF_CALLBACK){

    private var onClick : IOnClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {

        val binding = VerticalRestaurantItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantViewHolder(binding)
    }

    class RestaurantViewHolder(private val binding: VerticalRestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: RestaurantProps, onClick: IOnClick?){
            binding.txtVertRest.text = restaurant.name
            binding.txtVertCuisine.text = restaurant.cuisine

            Glide.with(binding.root)
                .load(restaurant.imageUrl)
                .override(250,250)
                .into(binding.imgVertRest)


            itemView.setOnClickListener {
                onClick?.onClick(restaurant)
            }
        }
    }

    fun addListener(onClick: IOnClick?){
        this.onClick = onClick
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(getItem(position),onClick)
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