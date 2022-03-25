package com.example.lacuisine.ui.recipes.recyclermenu

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacuisine.data.RecipesTags

class MenuAdapter : RecyclerView.Adapter<MenuViewHolder>() {
    private val menu = mutableListOf<RecipesTags>()
    private val fakeMenu = listOf("Veggie", "Dessert", "Meat", "Fruits", "Gluten Free", "Drinks")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindModelToView(fakeMenu[position])
    }

    override fun getItemCount(): Int = fakeMenu.size
}