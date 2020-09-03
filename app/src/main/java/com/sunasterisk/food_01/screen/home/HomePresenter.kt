package com.sunasterisk.food_01.screen.home

import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener
import com.sunasterisk.food_01.data.source.repository.CategoryRepository
import com.sunasterisk.food_01.data.source.repository.RecipeRandomRepository
import com.sunasterisk.food_01.screen.home.HomeContract.Presenter

class HomePresenter constructor(
    private val repository: CategoryRepository?,
    private val recipeRandom: RecipeRandomRepository?
) : Presenter {

    private var view: HomeContract.View? = null

    override fun onStart() {
        getCategory()
        getRecipeRandom()
    }

    override fun onStop() {}

    override fun setView(view: HomeContract.View?) {
        this.view = view
    }

    override fun getCategory() {
        repository?.getCategory(object : OnFetchDataJsonListener<MutableList<Category>> {
            override fun onSuccess(data: MutableList<Category>) {
                view?.onGetCategorySuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun getRecipeRandom() {
        recipeRandom?.getRecipeRandom(object : OnFetchDataJsonListener<MutableList<Recipe>> {
            override fun onSuccess(data: MutableList<Recipe>) {
                view?.onGetRecipeRandomSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }
}
