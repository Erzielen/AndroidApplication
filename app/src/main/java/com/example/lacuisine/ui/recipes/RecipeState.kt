package com.example.lacuisine.ui.recipes

import com.example.lacuisine.data.Recipe

sealed class RecipeState {
    object None : RecipeState()
    object Loading : RecipeState()
    object Failure : RecipeState()
    data class Success(
        val recipes:List<Recipe>
    ): RecipeState()
}