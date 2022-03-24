package com.example.lacuisine.repository

import com.example.lacuisine.networking.RecipesAPI
import com.example.lacuisine.repositories.RecipesRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RecipesRepositoryUnitTest {
    lateinit var repo:RecipesRepository
    @MockK
    lateinit var recipesAPI: RecipesAPI
    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }
    @Test
    fun fetchUserReturnsDefaultUserIfNoUserFound()= runBlocking {
        //Given
        every {  }
        //When

        //Then
    }
}