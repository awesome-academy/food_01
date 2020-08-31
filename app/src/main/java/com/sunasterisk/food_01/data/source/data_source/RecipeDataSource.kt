package com.sunasterisk.food_01.data.source.data_source

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener

interface RecipeDataSource {
    interface Local

    interface Remote {
        fun getRecipeByName(
            strFood: String?,
            listener: OnFetchDataJsonListener<MutableList<Recipe>>
        )
    }
}
