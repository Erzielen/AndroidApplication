package com.example.lacuisine.repositories

import com.example.lacuisine.data.RecipesAPIResponse
import com.example.lacuisine.networking.RecipesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface RecipesRepositoryContract {
    suspend fun fetchRecipesByTag(tag: String?): RecipesAPIResponse
}

class RecipesRepository(private val recipesAPI: RecipesAPI) : RecipesRepositoryContract {

    override suspend fun fetchRecipesByTag(tag: String?): RecipesAPIResponse =
        withContext(Dispatchers.IO) {
            return@withContext recipesAPI.getRandomRecipesByTag(tag)
        }
}