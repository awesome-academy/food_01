package com.sunasterisk.food_01.data.source.remote.api

import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.model.CategoryEntry
import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.model.RecipeEntry
import org.json.JSONObject

class PasreJson {
    fun recipeParseJson(jsonObject: JSONObject) =
        Recipe(
            idRecipe = jsonObject.getString(RecipeEntry.ID_RECIPE),
            name = jsonObject.getString(RecipeEntry.NAME),
            category = jsonObject.getString(RecipeEntry.CATEGORY),
            area = jsonObject.getString(RecipeEntry.AREA),
            instructions = jsonObject.getString(RecipeEntry.INSTRUCTIONS),
            tag = jsonObject.getString(RecipeEntry.TAG),
            urlImage = jsonObject.getString(RecipeEntry.URL_IMAGE),
            tags = jsonObject.getString(RecipeEntry.TAGS),
            urlVideo = jsonObject.getString(RecipeEntry.URL_VIDEO),
            ingre1 = jsonObject.getString(RecipeEntry.INGRE1),
            ingre2 = jsonObject.getString(RecipeEntry.INGRE2),
            ingre3 = jsonObject.getString(RecipeEntry.INGRE3),
            ingre4 = jsonObject.getString(RecipeEntry.INGRE4),
            ingre5 = jsonObject.getString(RecipeEntry.INGRE5),
            ingre6 = jsonObject.getString(RecipeEntry.INGRE6),
            ingre7 = jsonObject.getString(RecipeEntry.INGRE7),
            ingre8 = jsonObject.getString(RecipeEntry.INGRE8),
            ingre9 = jsonObject.getString(RecipeEntry.INGRE9),
            ingre10 = jsonObject.getString(RecipeEntry.INGRE10),
            measure1 = jsonObject.getString(RecipeEntry.MEASURE1),
            measure2 = jsonObject.getString(RecipeEntry.MEASURE2),
            measure3 = jsonObject.getString(RecipeEntry.MEASURE3),
            measure4 = jsonObject.getString(RecipeEntry.MEASURE4),
            measure5 = jsonObject.getString(RecipeEntry.MEASURE5),
            measure6 = jsonObject.getString(RecipeEntry.MEASURE6),
            measure7 = jsonObject.getString(RecipeEntry.MEASURE7),
            measure8 = jsonObject.getString(RecipeEntry.MEASURE8),
            measure9 = jsonObject.getString(RecipeEntry.MEASURE9),
            measure10 = jsonObject.getString(RecipeEntry.MEASURE10)
        )

    fun categoryParseJson(jsonObject: JSONObject) =
        Category(
            name = jsonObject.getString(CategoryEntry.NAME),
            image = jsonObject.getString(CategoryEntry.IMAGE),
            description = jsonObject.getString(CategoryEntry.DECRIPTION)
        )
}
