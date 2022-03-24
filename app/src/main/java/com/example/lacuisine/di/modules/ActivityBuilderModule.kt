package com.example.lacuisine.di.modules

import com.example.lacuisine.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuilderModule::class,
            ViewModelFactoryModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}