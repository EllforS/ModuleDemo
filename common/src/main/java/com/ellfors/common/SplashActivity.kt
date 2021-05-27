package com.ellfors.common

import com.ellfors.common.base.BaseActivity
import com.ellfors.common.constants.RouterKey
import com.ellfors.common.databinding.ActivitySplashBinding
import com.ellfors.common.entity.SampleARouterBean
import com.ellfors.common.util.open

/**
 * SplashActivity
 * 2021-03-25 17:08
 */
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun init() {
//        ARouter.getInstance()
//            .build(RouterKey.ModuleA.PAGE_A)
//            .navigation()

        mBinding.btnNavigate.setOnClickListener {
            open(RouterKey.ModuleA.PAGE_A) {
                withObject(RouterKey.ModuleA.EXTRA_TEST, SampleARouterBean("字符串", 100))
            }
        }
    }
}