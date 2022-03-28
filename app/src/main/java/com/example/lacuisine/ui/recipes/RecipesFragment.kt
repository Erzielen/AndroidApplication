package com.example.lacuisine.ui.recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lacuisine.databinding.FragmentRecipesBinding
import com.example.lacuisine.ui.recipes.recycler.RecipesAdapter
import com.example.lacuisine.ui.recipes.recyclermenu.FoodCategoryListener
import com.example.lacuisine.ui.recipes.recyclermenu.MenuAdapter
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipesFragment : DaggerFragment(), FoodCategoryListener {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    private val recipeViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            viewModelFactory
        )[RecipesViewModel::class.java]
    }

    private val recipeAdapter by lazy { RecipesAdapter() }
    private val menuAdapter by lazy { MenuAdapter(this) }
    private lateinit var binding: FragmentRecipesBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setupRecyclerViews()
        recipeViewModel.fetchRecipesByTag(tag = null)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        fun newInstance() = RecipesFragment()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            recipeViewModel.recipeState.collectLatest {
                when (it) {
                    is RecipeState.None -> logThis("Nothing")
                    is RecipeState.Failure -> logThis("Failure Recipe Response")
                    is RecipeState.Loading -> logThis("Loading")
                    is RecipeState.Success -> recipeAdapter.addRecipe(it.recipes)
                }
            }
        }
    }

    private fun setupRecyclerViews() {
        binding.apply {
            recipeRecycler.adapter = recipeAdapter
            menuRecycler.adapter = menuAdapter
            menuRecycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    private fun logThis(msg: String) {
        Log.d("Recipes Fragment", msg)
    }

    override fun onFoodCategorySelected(tag: String?) {
        recipeViewModel.fetchRecipesByTag(tag)
    }

}
