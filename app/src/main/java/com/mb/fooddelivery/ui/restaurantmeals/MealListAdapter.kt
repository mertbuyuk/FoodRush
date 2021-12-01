package com.mb.fooddelivery.ui.restaurantmeals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mb.fooddelivery.databinding.ItemMealBinding
import com.mb.fooddelivery.model.data.meals.MealProps
import com.mb.fooddelivery.ui.restaurantlist.IOnClick

class MealListAdapter : ListAdapter<MealProps, MealListAdapter.MealViewHolder>(DIFF_CALLBACK){

    private lateinit var onClick : IMealOnClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {

        val binding = ItemMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MealViewHolder(binding)
    }

    class MealViewHolder(private val binding: ItemMealBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: MealProps, onClick: IMealOnClick){
            binding.txtMealName.text = meal.name
            binding.txtMealDesc.text = meal.desc
            binding.txtMealPrice.text = meal.price.toString()

            Glide.with(binding.root)
                .load(meal.imageUrl)
                .into(binding.imgMeal)

            itemView.setOnClickListener {
                onClick.mealClick(meal)
            }
        }
    }


    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position),onClick)
    }

    fun addListener(onClick: IMealOnClick) {
        this.onClick = onClick
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MealProps>() {
            override fun areItemsTheSame(oldItem: MealProps, newItem: MealProps) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MealProps, newItem: MealProps) =
                oldItem == newItem
        }
    }
}