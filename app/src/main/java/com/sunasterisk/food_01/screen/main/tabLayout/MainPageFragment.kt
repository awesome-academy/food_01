package com.sunasterisk.food_01.screen.main.tabLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sunasterisk.food_01.R
import com.sunasterisk.food_01.screen.mainPage.MainPagerAdapter
import com.sunasterisk.food_01.screen.detail.DetailFragment
import com.sunasterisk.food_01.screen.favorite.FavoriteFragment
import com.sunasterisk.food_01.screen.home.HomeFragment
import com.sunasterisk.food_01.screen.search.SearchFragment
import kotlinx.android.synthetic.main.fragment_tab.*

class MainPageFragment : Fragment() {
    private val homeFragment = HomeFragment.newInstance()
    private val favoriteFragment = FavoriteFragment.newInstance()
    private val searchFragment = SearchFragment.newInstance()
    private val detailFragment = DetailFragment.newInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabLayout()
    }

    private fun setupTabLayout() {
        setupViewPager()
        tabLayout.setupWithViewPager(viewPager)
        setupTabIcons()
    }

    private fun setupTabIcons() {
        tabLayout.getTabAt(HOME_PAGE)?.setIcon(R.drawable.ic_home)
        tabLayout.getTabAt(FAVORITE_PAGE)?.setIcon(R.drawable.ic_heart)
        tabLayout.getTabAt(SEARCH_PAGE)?.setIcon(R.drawable.ic_search)
        tabLayout.getTabAt(DETAIL_PAGE)?.setIcon(R.drawable.ic_details)
    }

    private fun setupViewPager() {
        viewPager.adapter = activity?.supportFragmentManager?.let {
            MainPagerAdapter(it).apply {
                addFragment(homeFragment, resources.getString(R.string.home))
                addFragment(favoriteFragment, resources.getString(R.string.favorite))
                addFragment(searchFragment, resources.getString(R.string.search))
                addFragment(detailFragment, resources.getString(R.string.detail))
            }
        }
    }

    companion object {
        private const val HOME_PAGE = 0
        private const val FAVORITE_PAGE = 1
        private const val SEARCH_PAGE= 2
        private const val DETAIL_PAGE = 3
    }
}
