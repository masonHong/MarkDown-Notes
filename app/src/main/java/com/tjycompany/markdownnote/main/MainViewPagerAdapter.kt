package com.tjycompany.markdownnote.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.tjycompany.markdownnote.base.BaseTabFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager,
                           private val items: List<BaseTabFragment>) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = items[position]

    override fun getCount(): Int = items.size

    override fun getPageTitle(position: Int): CharSequence? {
        return items[position].getTabTitle()
    }
}