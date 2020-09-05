package com.sunasterisk.food_01.screen.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.data.model.Recipe
import com.sunasterisk.food_01.data.source.repository.RecipeRepository
import com.sunasterisk.food_01.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(),
    SearchContract.View, OnItemRecyclerViewClickListener<Recipe> {
    private val adapter: SearchAdapter by lazy { SearchAdapter() }
    private val presenter = SearchPresenter(RecipeRepository.instance)
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        initData()

        searchFoodEditText.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> searchFood(searchFoodEditText.text.toString())
                }
                return v?.onTouchEvent(event) ?: true
            }
        })
    }

    private fun initView() {
        searchFoodRecycler.setHasFixedSize(true)
        searchFoodRecycler.adapter = adapter
        adapter.registerItemRecyclerViewClickListener(this)
        layoutManager = LinearLayoutManager(activity)
        searchFoodRecycler.layoutManager = layoutManager
    }

    private fun initData() {
        presenter.setView(this)
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onGetRecipesSuccess(recipes: MutableList<Recipe>) {
        recipes.let { adapter.updateData(it) }
    }

    override fun onError(exception: Exception?) {
        Log.e("error", exception.toString())
    }

    override fun onItemClickListener(item: Recipe?) {
        // TODO: job need execute later
    }

    fun searchFood(str: String?) {
        presenter.getRecipes(str)
    }
}
