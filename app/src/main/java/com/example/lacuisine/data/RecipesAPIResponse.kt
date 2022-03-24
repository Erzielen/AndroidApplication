package com.example.lacuisine.data

data class RecipesAPIResponse (
    val recipes: List<Recipe>
)

data class Recipe (
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val veryHealthy: Boolean,
    val cheap: Boolean,
    val veryPopular: Boolean,
    val sustainable: Boolean,
    val weightWatcherSmartPoints: Long,
    val gaps: String,
    val lowFodmap: Boolean,
    val aggregateLikes: Long,
    val spoonacularScore: Long,
    val healthScore: Long,
    val creditsText: String,
    val license: String,
    val sourceName: String,
    val pricePerServing: Double,
    val extendedIngredients: List<ExtendedIngredient>,
    val id: Long,
    val title: String,
    val readyInMinutes: Long,
    val servings: Long,
    val sourceURL: String,
    val image: String,
    val imageType: String,
    val summary: String,
    val cuisines: List<Any?>,
    val dishTypes: List<String>,
    val diets: List<String>,
    val occasions: List<String>,
    val instructions: String,
    val analyzedInstructions: List<AnalyzedInstruction>,
    val originalID: Any? = null,
    val spoonacularSourceURL: String
)

data class AnalyzedInstruction (
    val name: String,
    val steps: List<Step>
)

data class Step (
    val number: Long,
    val step: String,
    val ingredients: List<Ent>,
    val equipment: List<Ent>,
    val length: Length? = null
)

data class Ent (
    val id: Long,
    val name: String,
    val localizedName: String,
    val image: String,
    val temperature: Length? = null
)

data class Length (
    val number: Long,
    val unit: String
)

data class ExtendedIngredient (
    val id: Long,
    val aisle: String,
    val image: String,
    val consistency: Consistency,
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val amount: Double,
    val unit: String,
    val meta: List<String>,
    val measures: Measures
)

enum class Consistency {
    Liquid,
    Solid
}

data class Measures (
    val us: Metric,
    val metric: Metric
)

data class Metric (
    val amount: Double,
    val unitShort: String,
    val unitLong: String
)
