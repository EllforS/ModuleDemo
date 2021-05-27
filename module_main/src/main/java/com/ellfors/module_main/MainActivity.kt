package com.ellfors.module_main

import com.ellfors.common.base.BaseActivity
import com.ellfors.common.util.toast
import com.ellfors.module_main.databinding.ActivityMainBinding

/**
 * MainActivity
 * 2021-05-27 15:40
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun init() {
        mBinding.vp2.adapter = MainVPAdapter(this)
        mBinding.vp2.isUserInputEnabled = false
        mBinding.bottom.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.PAGE_A) {
                mBinding.vp2.currentItem = 0
            } else if (it.itemId == R.id.PAGE_B) {
                mBinding.vp2.currentItem = 1
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}