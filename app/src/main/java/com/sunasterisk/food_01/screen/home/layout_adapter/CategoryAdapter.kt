package com.sunasterisk.food_01.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.source.remote.dowload_image.DownloadImage
import kotlinx.android.synthetic.main.row_category_layout.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoriesViewHolder>() {
    private val category = mutableListOf<Category>()

    fun updateData(category: MutableList<Category>?) {
        category?.let {
            this.category.clear()
            this.category.addAll(category)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CategoriesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_category_layout, parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bindData(category[position])
    }

    override fun getItemCount() = category.size

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(category: Category) {
            itemView.run {
                textNameCategory.text = category.name
                DownloadImage {
                    imageCategory.setImageBitmap(it)
                }.execute(category.image)
            }
        }
    }
}
