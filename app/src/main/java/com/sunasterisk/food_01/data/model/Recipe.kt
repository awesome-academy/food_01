package com.sunasterisk.food_01.data.model

data class Recipe(
    val idRecipe: String = "",
    val name: String = "",
    val category: String = "",
    val area: String = "",
    val instructions: String = "",
    val urlImage: String = "",
    val urlVideo: String = "",
    val ingre1: String = "",
    val ingre2: String = "",
    val ingre3: String = "",
    val ingre4: String = "",
    val ingre5: String = "",
    val ingre6: String = "",
    val ingre7: String = "",
    val ingre8: String = "",
    val ingre9: String = "",
    val ingre10: String = "",
    val measure1: String = "",
    val measure2: String = "",
    val measure3: String = "",
    val measure4: String = "",
    val measure5: String = "",
    val measure6: String = "",
    val measure7: String = "",
    val measure8: String = "",
    val measure9: String = "",
    val measure10: String = ""
)

object RecipeEntry {
    const val RECIPE = "results"
    const val ID_RECIPE = "idMeal"
    const val NAME = "strMeal"
    const val CATEGORY = "strCategory"
    const val AREA = "strArea"
    const val INSTRUCTIONS = "strInstructions"
    const val URL_IMAGE = "strMealThumb"
    const val URL_VIDEO = "strYoutube"
    const val INGRE1 = "strIngredient1"
    const val INGRE2 = "strIngredient2"
    const val INGRE3 = "strIngredient3"
    const val INGRE4 = "strIngredient4"
    const val INGRE5 = "strIngredient5"
    const val INGRE6 = "strIngredient6"
    const val INGRE7 = "strIngredient7"
    const val INGRE8 = "strIngredient8"
    const val INGRE9 = "strIngredient9"
    const val INGRE10 = "strIngredient10"
    const val MEASURE1 = "strMeasure1"
    const val MEASURE2 = "strMeasure2"
    const val MEASURE3 = "strMeasure3"
    const val MEASURE4 = "strMeasure4"
    const val MEASURE5 = "strMeasure5"
    const val MEASURE6 = "strMeasure6"
    const val MEASURE7 = "strMeasure7"
    const val MEASURE8 = "strMeasure8"
    const val MEASURE9 = "strMeasure9"
    const val MEASURE10 = "strMeasure10"
}
