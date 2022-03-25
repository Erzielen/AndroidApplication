package com.example.lacuisine.ui.recipes.recyclermenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacuisine.databinding.ItemMenuRecipesBinding

class MenuViewHolder(
    val parent: ViewGroup,
    private val binding: ItemMenuRecipesBinding = ItemMenuRecipesBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {

    fun bindModelToView(fakeMenuItem: String) {
        binding.recipesTitleCategory.text = fakeMenuItem
    }
}


