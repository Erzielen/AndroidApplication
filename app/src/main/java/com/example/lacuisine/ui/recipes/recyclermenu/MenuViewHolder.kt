package com.example.lacuisine.ui.recipes.recyclermenu

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacuisine.databinding.ItemMenuRecipesBinding

interface FoodCategoryListener {
    fun onFoodCategorySelected(tag: String?)
}

class MenuViewHolder(
    val parent: ViewGroup,
    private val binding: ItemMenuRecipesBinding = ItemMenuRecipesBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {

    fun bindModelToView(selectedFoodCategory: String, foodCategoryListener: FoodCategoryListener) {
        binding.recipesTitleCategory.text = selectedFoodCategory
        binding.root.setOnClickListener {
            foodCategoryListener.onFoodCategorySelected(tag = it.toString())
            Log.d(
                "bindModelView: ",
                "$it"
            )
        }
    }
}


