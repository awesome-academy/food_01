package com.sunasterisk.food_01.data.source.data_source

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener

interface RecipeRandomDataSource {
    /**
     * Remote
     */
    interface Remote {
        fun getRecipeRandom(listener: OnFetchDataJsonListener<MutableList<Recipe>>)
    }
}
