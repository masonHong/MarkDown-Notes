package com.tjycompany.markdownnote.base

import android.support.v4.app.Fragment

abstract class BaseTabFragment : Fragment() {
    abstract fun getTabTitle(): String
}