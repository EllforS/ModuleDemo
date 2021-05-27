package com.ellfors.module_main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ellfors.common.constants.RouterKey
import com.ellfors.common.util.open

/**
 * MainVPAdapter
 * 2021-05-27 17:26
 */
class MainVPAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> open(RouterKey.ModuleA.PAGE_A) as Fragment
            1 -> open(RouterKey.ModuleB.FRAGMENT_B) as Fragment
            else -> Fragment()
        }
    }
}