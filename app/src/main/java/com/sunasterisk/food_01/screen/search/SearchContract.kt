package com.sunasterisk.food_01.screen.search

import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.utils.BasePresenter
import java.lang.Exception

interface SearchContract {
    interface View {
        fun onGetRecipesSuccess(recipes: MutableList<Recipe>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getRecipes(strName: String?)
    }
}