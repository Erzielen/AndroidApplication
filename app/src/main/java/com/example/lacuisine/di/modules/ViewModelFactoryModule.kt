package com.example.lacuisine.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.lacuisine.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewFactoryModule(factory: ViewModelFactory) : ViewModelProvider.Factory
}