package com.mb.fooddelivery.ui.mainpage.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mb.fooddelivery.databinding.ItemSlideBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.SliderViewHolder>() {

    lateinit var list : List<Int>

    fun setContentList(list: List<Int>)
    {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = ItemSlideBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.image.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SliderViewHolder(private val binding : ItemSlideBinding) : RecyclerView.ViewHolder(binding.root) {

       var image = binding.slideItem
    }

}