package com.example.lacuisine.di.modules

import com.example.lacuisine.ui.recipes.RecipesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun providesRecipesFragment(): RecipesFragment
}