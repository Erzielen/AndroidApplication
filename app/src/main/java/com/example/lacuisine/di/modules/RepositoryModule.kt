package com.example.lacuisine.di.modules

import com.example.lacuisine.networking.RecipesAPI
import com.example.lacuisine.repositories.RecipesRepository
import com.example.lacuisine.repositories.RecipesRepositoryContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesRecipesRepository(recipesAPI: RecipesAPI) : RecipesRepositoryContract =
        RecipesRepository(recipesAPI)
}