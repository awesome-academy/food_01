package com.sunasterisk.food_01.screen.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.remote.dowload_image.DownloadImage
import com.sunasterisk.food_01.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_layout_food.view.*

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder?>() {
    private val recipes = mutableListOf<Recipe>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Recipe>? = null

    fun updateData(recipes: MutableList<Recipe>?) {
        recipes?.let {
            this.recipes.clear()
            this.recipes.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Recipe>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_food, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(recipes[position])
    }

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<Recipe>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Recipe>? = null

        override fun onClick(v: View?) {
            listener?.onItemClickListener(recipes[adapterPosition])
        }

        fun bindViewData(recipe: Recipe) {
            itemView.run {
                foodNameView.text = recipe.name
                foodTagsView.text = recipe.tags
                DownloadImage {
                    itemView.foodImageView.setImageBitmap(it)
                }.execute(recipe.urlImage)
            }
            itemView.setOnClickListener(this)
            listener = itemListener
        }
    }
}
