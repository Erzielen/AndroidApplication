package com.example.lacuisine.di.modules

import androidx.lifecycle.ViewModel
import com.example.lacuisine.di.viewmodel.ViewModelKey
import com.example.lacuisine.ui.recipes.RecipesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RecipesViewModel::class)
    abstract fun bindRecipeViewModel(viewModel: RecipesViewModel):ViewModel
}