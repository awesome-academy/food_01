package com.sunasterisk.food_01.data.source.remote

import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.model.CategoryEntry
import com.sunasterisk.food_01.data.source.data_source.CategoryDataSource
import com.sunasterisk.food_01.data.source.remote.api.GetJsonFromUrl
import com.sunasterisk.food_01.data.source.remote.base_url.BaseUrl

class CategoryRemoteDataSource : CategoryDataSource.Remote {

    override fun getCategory(listener: OnFetchDataJsonListener<MutableList<Category>>) {
        GetJsonFromUrl(listener, CategoryEntry.OBJECT).execute(BaseUrl.BASE_URL_ALL_CATEGORY)
    }

    companion object {
        private var instance: CategoryDataSource.Remote? = null

        fun getInstance() =
            instance ?: CategoryRemoteDataSource().also { instance = it }
    }
}
