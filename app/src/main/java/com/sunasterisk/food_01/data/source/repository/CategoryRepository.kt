package com.sunasterisk.food_01.data.source.repository

import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.source.data_source.CategoryDataSource
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener

class CategoryRepository private constructor(
    private val remote: CategoryDataSource.Remote
) {

    fun getCategory(listener: OnFetchDataJsonListener<MutableList<Category>>) {
        remote.getCategory(listener)
    }

    companion object {
        private var instance: CategoryRepository? = null

        fun getInstance(
            remote: CategoryDataSource.Remote
        ) =
            instance ?: CategoryRepository(remote).also { instance = it }
    }
}
