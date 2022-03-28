package com.example.lacuisine.ui.recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lacuisine.repositories.RecipesRepositoryContract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipesViewModel @Inject constructor(
    private val recipeRepo: RecipesRepositoryContract
) : ViewModel() {

    private val _recipeState: MutableStateFlow<RecipeState> = MutableStateFlow(RecipeState.None)
    val recipeState: StateFlow<RecipeState> by lazy { _recipeState }

    fun fetchRecipesByTag(tag: String?) {
        _recipeState.value = RecipeState.Loading
        viewModelScope.launch {
            try {
                _recipeState.value = RecipeState.Success(recipeRepo.fetchRecipesByTag(tag).recipes)
            } catch (e: Throwable) {
                _recipeState.value = RecipeState.Failure
            }
        }
    }
}