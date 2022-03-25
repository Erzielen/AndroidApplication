package com.example.lacuisine.ui.recipes.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacuisine.data.Recipe

class RecipesAdapter : RecyclerView.Adapter<RecipesViewHolder>(){

    private val recipes = mutableListOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        return RecipesViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bindModelToView(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    fun addRecipe(newRecipe : List<Recipe>){
        recipes.addAll(newRecipe)
        notifyDataSetChanged()
    }
}