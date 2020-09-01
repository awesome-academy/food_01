package com.sunasterisk.food_01.utils

interface BasePresenter<T> {
    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
