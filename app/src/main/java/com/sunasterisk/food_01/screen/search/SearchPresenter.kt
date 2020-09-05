package com.sunasterisk.food_01.screen.search

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener
import com.sunasterisk.food_01.data.source.repository.RecipeRepository
import com.sunasterisk.food_01.utils.BasePresenter

class SearchPresenter constructor(
    private val repository: RecipeRepository?
) : SearchContract.Presenter {
    private var view: SearchContract.View? = null

    override fun getRecipes(strName: String?) {
        repository?.getRecipesByName(
            strName,
            object : OnFetchDataJsonListener<MutableList<Recipe>> {
                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }

                override fun onSuccess(data: MutableList<Recipe>) {
                    view?.onGetRecipesSuccess(data)
                }
            })
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: SearchContract.View?) {
        this.view = view
    }
}