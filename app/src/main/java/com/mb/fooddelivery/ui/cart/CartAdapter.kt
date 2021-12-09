package com.mb.fooddelivery.ui.cart


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mb.fooddelivery.databinding.ItemCartBinding
import com.mb.fooddelivery.model.data.cart.MealInfo
import androidx.recyclerview.widget.ListAdapter as ListAdapter

class CartAdapter : ListAdapter<MealInfo, CartAdapter.CartViewHolder>(DIFF_CALLBACK) {
    class CartViewHolder(private val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mealInfo: MealInfo){

            binding.apply {
                txtCartMealName.text = mealInfo.mealInfo.name
                txtCartMealPrice.text = mealInfo.mealInfo.price.toString()
                txtCartMealCount.text = mealInfo.count.toString()

                Glide.with(root)
                    .load(mealInfo.mealInfo.imageUrl)
                    .fitCenter()
                    .into(imgCartMeal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun removeItem(position: Int){
        val currentList =  currentList.toMutableList()
        currentList.removeAt(position)
        submitList(currentList)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MealInfo>() {
            override fun areItemsTheSame(oldItem: MealInfo, newItem: MealInfo) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: MealInfo, newItem: MealInfo) =
                oldItem == newItem
        }
    }
}