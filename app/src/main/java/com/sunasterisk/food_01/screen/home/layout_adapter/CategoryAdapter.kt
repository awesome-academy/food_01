package com.sunasterisk.food_01.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.source.remote.dowload_image.DownloadImage
import com.sunasterisk.food_01.utils.OnItemRecyclerViewClickListenner
import kotlinx.android.synthetic.main.row_category_layout.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoriesViewHolder>() {
    private val category = mutableListOf<Category>()
    private var onItemClickListener: OnItemRecyclerViewClickListenner<Category>? = null

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListenner<Category>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

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

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var listenner: OnItemRecyclerViewClickListenner<Category>? = null

        fun bindData(category: Category) {
            itemView.run {
                textNameCategory.text = category.name
                DownloadImage {
                    imageCategory.setImageBitmap(it)
                }.execute(category.image)
            }
            listenner = onItemClickListener
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            listenner?.onItemClickListener(category[adapterPosition])
        }
    }
}
