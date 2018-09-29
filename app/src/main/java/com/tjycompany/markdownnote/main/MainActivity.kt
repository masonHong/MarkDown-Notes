package com.tjycompany.markdownnote.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.tjycompany.markdownnote.base.BaseTabFragment
import com.tjycompany.markdownnote.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
    }

    private fun initViewPager() {
        val items = ArrayList<BaseTabFragment>()

        items.add(AllNotesFragment())
        items.add(CategoryFragment())

        viewPager.offscreenPageLimit = items.size
        viewPager.adapter = MainViewPagerAdapter(supportFragmentManager, items)

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position ?: 0
            }
        })
    }
}
