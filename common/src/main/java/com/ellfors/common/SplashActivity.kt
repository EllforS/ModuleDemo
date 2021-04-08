package com.ellfors.common

import android.util.Log
import com.ellfors.common.base.BaseActivity
import com.ellfors.common.databinding.ActivitySplashBinding

/**
 * SplashActivity
 * 2021-03-25 17:08
 */
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun init() {
//        ARouter.getInstance()
//            .build(RouterKey.ModuleA.PAGE_A)
//            .navigation()
        open(RouterKey.ModuleA.PAGE_A) {
            withObject(RouterKey.ModuleA.EXTRA_TEST, SampleARouterBean("字符串", 100))
        }
        finish()
    }
}