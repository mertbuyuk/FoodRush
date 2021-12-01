package com.mb.fooddelivery.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.fooddelivery.databinding.ItemCategoriesBinding
import com.mb.fooddelivery.model.data.categories.CategoriesCuisine

class CategoriesListAdapter : ListAdapter<CategoriesCuisine,CategoriesListAdapter.CategoryHolder>(DIFF_CALLBACK) {

    private var onClickI : ICategoryOnClick? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryHolder(binding)
  }


    class CategoryHolder(private val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(categoriesCuisine: CategoriesCuisine, onClickI: ICategoryOnClick?){
            binding.itemTextCategories.text = categoriesCuisine.name

            itemView.setOnClickListener {
                onClickI?.onClick(categoriesCuisine)
            }
        }
    }

    fun addListener(onClickI: ICategoryOnClick?){
        this.onClickI = onClickI
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(getItem(position),onClickI)
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



