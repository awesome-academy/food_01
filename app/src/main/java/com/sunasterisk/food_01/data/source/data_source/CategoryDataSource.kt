package com.sunasterisk.food_01.data.source.data_source

import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener

interface CategoryDataSource {
    /**
     * Remote
     */
    interface Remote {
        fun getCategory(listener: OnFetchDataJsonListener<MutableList<Category>>)
    }
}
