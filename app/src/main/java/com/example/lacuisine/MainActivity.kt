package com.example.lacuisine

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lacuisine.ui.recipes.RecipesFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private val manager by lazy { supportFragmentManager }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(RecipesFragment.newInstance())
    }

    private fun changeFragment(newFragment: Fragment){
        manager.beginTransaction().replace(R.id.fragment_container,newFragment).commit()
    }
}