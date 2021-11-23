package com.mb.fooddelivery.ui.mainpage.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.fooddelivery.databinding.ItemCategoriesBinding
import com.mb.fooddelivery.model.data.categories.CategoriesCuisine
import com.mb.fooddelivery.model.data.restaurant.RestaurantProps

class CategoriesListAdapter : ListAdapter<CategoriesCuisine,CategoriesListAdapter.CategoryHolder>(DIFF_CALLBACK) {
  /*  val categories = listOf(
        CategoriesCuisine("Pizza"),
        CategoriesCuisine("Burger"),
        CategoriesCuisine("Bakery"),
        CategoriesCuisine("Dessert"),
        CategoriesCuisine("Worldwide"),
        CategoriesCuisine("Homemade"),
        CategoriesCuisine("Breakfast"),
        CategoriesCuisine("Kebab"),
        CategoriesCuisine("Pasta - Salad"),
        CategoriesCuisine("Doner"),
        CategoriesCuisine("Seafood"),
        CategoriesCuisine("Eastern Kitchen"),
    )*/

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryHolder(binding)
  }


    class CategoryHolder(private val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(categoriesCuisine: CategoriesCuisine){
            binding.itemTextCategories.text = categoriesCuisine.name
        }
    }



    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CategoriesCuisine>() {
            override fun areItemsTheSame(oldItem: CategoriesCuisine, newItem: CategoriesCuisine) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: CategoriesCuisine, newItem: CategoriesCuisine) =
                oldItem == newItem
        }
    }
}



