package com.sunasterisk.food_01.data.source.repository

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.data_source.RecipeRandomDataSource
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener

class RecipeRandomRepository private constructor(
    private val remote: RecipeRandomDataSource.Remote
) {

    fun getRecipeRandom(listener: OnFetchDataJsonListener<MutableList<Recipe>>) {
        remote.getRecipeRandom(listener)
    }

    companion object {
        private var instance: RecipeRandomRepository? = null

        fun getInstance(remote: RecipeRandomDataSource.Remote) =
            instance ?: RecipeRandomRepository(remote).also { instance = it }
    }
}
