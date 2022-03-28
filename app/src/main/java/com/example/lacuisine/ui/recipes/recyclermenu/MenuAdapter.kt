package com.example.lacuisine.ui.recipes.recyclermenu

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacuisine.data.RecipesTags

class MenuAdapter(
    private val foodCategoryListener: FoodCategoryListener
) : RecyclerView.Adapter<MenuViewHolder>() {
    private val foodCategories = listOf("Veggie", "Dessert", "Meat", "Fruits", "Gluten Free", "Drinks")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindModelToView(foodCategories[position], foodCategoryListener)
    }

    override fun getItemCount(): Int = foodCategories.size
}