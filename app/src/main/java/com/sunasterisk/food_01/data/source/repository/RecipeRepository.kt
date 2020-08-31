package com.sunasterisk.food_01.data.source.repository

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.data_source.RecipeDataSource
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener
import com.sunasterisk.food_01.data.source.remote.RecipeRemoteDataSource

class RecipeRepository(private val remote: RecipeDataSource.Remote) {
    private object Holder {
        val INSTANCE = RecipeRepository(remote = RecipeRemoteDataSource.instance)
    }

    fun getRecipeByName(
        strFood: String?,
        listener: OnFetchDataJsonListener<MutableList<Recipe>>
    ) {
        remote.getRecipeByName(strFood, listener)
    }

    companion object {
        val instance: RecipeRepository by lazy { Holder.INSTANCE }
    }
}
