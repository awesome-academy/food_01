package com.sunasterisk.food_01.data.model

data class Category (
    var name: String,
    var image: String,
    var description: String
)

object CategoryEntry {
    const val OBJECT = "categories"
    const val NAME = "strCategory"
    const val IMAGE = "strCategoryThumb"
    const val DECRIPTION = "strCategoryDescription"
}
