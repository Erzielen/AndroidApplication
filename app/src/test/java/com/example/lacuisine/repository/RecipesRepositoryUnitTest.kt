package com.example.lacuisine.repository

import com.example.lacuisine.data.Recipe
import com.example.lacuisine.data.RecipesAPIResponse
import com.example.lacuisine.networking.RecipesAPI
import com.example.lacuisine.repositories.RecipesRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RecipesRepositoryUnitTest {

    lateinit var repo: RecipesRepository

    @MockK
    lateinit var fakeRecipesAPI: RecipesAPI

    val fakeRecipe = Recipe(
        vegetarian = false,
        vegan = false,
        glutenFree = false,
        dairyFree = false,
        false,
        false,
        false,
        false,
        1,
        "this",
        false,
        2,
        3,
        4,
        5,
        6,
        "this",
        "this",
        7.0,
        extendedIngredients = listOf(),
        8,
        title = "This is a fake Recipe",
        9,
        10,
        "url",
        "image",
        "imageType",
        "summary",
        cuisines = listOf(),
        dishTypes = listOf(),
        diets = listOf(),
        occasions = listOf(),
        instructions = "instructions",
        analyzedInstructions = listOf(),
        "url",
        "url"
    )
    val fakeRecipesCreated = RecipesAPIResponse(
        listOf(fakeRecipe)
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repo = RecipesRepository(fakeRecipesAPI)
    }

    @Test
    fun testFetchAPIRecipesReturnsData() = runBlocking {
        //Given
        coEvery { fakeRecipesAPI.getRecipes() } returns fakeRecipesCreated
        //When
        val response = repo.fetchRecipes()
        //Then
        assert(response == fakeRecipesCreated)
        coVerify { fakeRecipesAPI.getRecipes() }
    }
}