package com.example.lacuisine.ui.recipes.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lacuisine.data.Recipe
import com.example.lacuisine.databinding.ItemRowRecipesBinding

class RecipesViewHolder(
    val parent: ViewGroup,
    private val binding: ItemRowRecipesBinding = ItemRowRecipesBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {

    fun bindModelToView(recipe : Recipe){
        binding.recipeName.text = recipe.title
        binding.recipeDescription.text=recipe.dishTypes.toString()
        Glide.with(binding.root.context).load(recipe.image).into(binding.recipeImage)
    }
}