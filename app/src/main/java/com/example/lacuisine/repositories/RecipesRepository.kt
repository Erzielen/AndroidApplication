package com.example.lacuisine.repositories

import com.example.lacuisine.data.RecipesAPIResponse
import com.example.lacuisine.networking.RecipesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface RecipesRepositoryContract{
    suspend fun fetchRecipes():RecipesAPIResponse
}
class RecipesRepository (val recipesAPI: RecipesAPI) : RecipesRepositoryContract{

    override suspend fun fetchRecipes() = withContext( Dispatchers.IO){
        return@withContext recipesAPI.getRecipes()
    }
}