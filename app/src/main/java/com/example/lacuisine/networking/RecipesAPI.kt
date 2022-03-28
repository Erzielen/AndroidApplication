package com.example.lacuisine.networking

import com.example.lacuisine.data.RecipesAPIResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesAPI {

    @GET("recipes/random?number=50")
    suspend fun getRandomRecipesByTag(
        @Query
            ("tags") tags: String?
    ): RecipesAPIResponse
}