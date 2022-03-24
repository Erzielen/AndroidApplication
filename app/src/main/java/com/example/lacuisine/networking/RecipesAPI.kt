package com.example.lacuisine.networking

import com.example.lacuisine.data.RecipesAPIResponse
import retrofit2.http.GET

interface RecipesAPI {
    @GET ("recipes/random?number=50")
    suspend fun getRecipes(): RecipesAPIResponse
}