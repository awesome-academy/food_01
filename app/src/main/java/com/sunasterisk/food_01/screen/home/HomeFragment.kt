package com.sunasterisk.food_01.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.data.model.Category
import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.remote.CategoryRemoteDataSource
import com.sunasterisk.food_01.data.source.remote.RecipeRandomRemoteDataSource
import com.sunasterisk.food_01.data.source.remote.dowload_image.DownloadImage
import com.sunasterisk.food_01.data.source.repository.CategoryRepository
import com.sunasterisk.food_01.data.source.repository.RecipeRandomRepository
import com.sunasterisk.food_01.screen.home.layout_adapter.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {
    private val categoryAdapter by lazy { CategoryAdapter() }
    private val listRecipe = mutableListOf<Recipe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {
        val presenter = HomePresenter(
            CategoryRepository.getInstance(
                CategoryRemoteDataSource.getInstance()
            ),
            RecipeRandomRepository.getInstance(
                RecipeRandomRemoteDataSource.getInstance()
            )
        )
        presenter.run {
            setView(this@HomeFragment)
            onStart()
        }
    }

    override fun onGetCategorySuccess(category: MutableList<Category>) {
        categoryAdapter.updateData(category)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this.context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetRecipeRandomSuccess(recipe: MutableList<Recipe>) {
        listRecipe.addAll(recipe)
        textMealRecipe.text = listRecipe.first().name
        textTagRecipe.text = listRecipe.first().tag
        DownloadImage {
            imageMealThumbRecipe.setImageBitmap(it)
        }.execute(listRecipe.first().urlImage)
    }

    override fun onErrorRecipe(exception: Exception?) {
        Toast.makeText(this.context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        recyclerCategories.setHasFixedSize(true)
        recyclerCategories.adapter = categoryAdapter
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
