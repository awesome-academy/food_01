package com.sunasterisk.food_01.screen.home

import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener
import com.sunasterisk.food_01.data.source.repository.CategoryRepository
import com.sunasterisk.food_01.screen.home.HomeContract.Presenter

class HomePresenter constructor(
    private val repository: CategoryRepository?
) : Presenter {

    private var view: HomeContract.View? = null

    override fun onStart() {
        getCategory()
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
}
