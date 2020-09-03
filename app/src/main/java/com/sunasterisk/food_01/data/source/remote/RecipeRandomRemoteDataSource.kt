package com.sunasterisk.food_01.data.source.remote

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.model.RecipeEntry
import com.sunasterisk.food_01.data.source.data_source.RecipeRandomDataSource
import com.sunasterisk.food_01.data.source.remote.api.GetJsonFromUrl
import com.sunasterisk.food_01.data.source.remote.base_url.BaseUrl

class RecipeRandomRemoteDataSource : RecipeRandomDataSource.Remote {

    override fun getRecipeRandom(listener: OnFetchDataJsonListener<MutableList<Recipe>>) {
        GetJsonFromUrl(listener, RecipeEntry.OBJECT).execute(BaseUrl.BASE_URL_RECIPE)
    }

    companion object {
        private var instance: RecipeRandomDataSource.Remote? = null

        fun getInstance() =
            instance ?: RecipeRandomRemoteDataSource().also { instance = it }
    }
}
