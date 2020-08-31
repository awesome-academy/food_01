package com.sunasterisk.food_01.data.source.remote

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.model.RecipeEntry
import com.sunasterisk.food_01.data.source.data_source.RecipeDataSource
import com.sunasterisk.food_01.data.source.remote.api.GetJsonFromUrl
import com.sunasterisk.food_01.data.source.remote.base_url.BaseUrl

class RecipeRemoteDataSource : RecipeDataSource.Remote{
    private object Holder {
        val INSTANCE = RecipeRemoteDataSource()
    }

    override fun getRecipeByName(strFood: String?, listener: OnFetchDataJsonListener<MutableList<Recipe>>) {
        GetJsonFromUrl(listener, RecipeEntry.RECIPE).execute(BaseUrl.baseUrlRecipesByName(strFood))
    }

    companion object{
        val instance: RecipeRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
