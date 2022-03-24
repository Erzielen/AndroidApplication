package com.example.lacuisine.di.component

import android.app.Application
import com.example.lacuisine.RecipesApplication
import com.example.lacuisine.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        NetworkingModule::class,
        RepositoryModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent : AndroidInjector<RecipesApplication> {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application):AppComponent
    }
}