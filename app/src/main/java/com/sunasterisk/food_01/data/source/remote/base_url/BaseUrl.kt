package com.sunasterisk.food_01.data.source.remote.base_url

import com.sunasterisk.food_01.utils.Constant

object BaseUrl {
    const val BASE_URL_ALL_CATEGORY = Constant.BASE_URL + Constant.BASE_ALL_CATEGORY

    const val BASE_URL_RECIPE = Constant.BASE_URL + Constant.BASE_RANDOM

    fun baseUrlRecipesByName(strName: String?) = Constant.BASE_URL + Constant.BASE_SEARCH_BY_NAME + strName

    fun baseUrlRecipesById(strId: String?) = Constant.BASE_URL + Constant.BASE_SEARCH_BY_ID + strId
}
