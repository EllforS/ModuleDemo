package com.ellfors.modulea

import android.annotation.SuppressLint
import android.os.Environment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.ellfors.common.*
import com.ellfors.common.base.BaseActivity
import com.ellfors.modulea.databinding.ActivityPageABinding
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * PageAActivity
 * 2021-03-25 16:48
 */
@Route(path = RouterKey.ModuleA.PAGE_A)
class PageAActivity : BaseActivity<ActivityPageABinding>() {

    @JvmField
    @Autowired(name = RouterKey.ModuleA.EXTRA_TEST)
    var mSampleBean: SampleARouterBean? = null

    @SuppressLint("SetTextI18n")
    override fun init() {
        injectRouter()
        EventBus.getDefault().register(this)

        requestMyPermissions()

        mSampleBean?.apply {
            mBinding.tvTest.text = (valueA ?: "A空") + valueB
        }

        mBinding.btnPageb.setOnClickListener {
            open(RouterKey.ModuleB.PAGE_B) {
                withString(RouterKey.ModuleB.EXTRA_VALUE, "传递的参数")
            }
        }

        mBinding.btnSingle.setOnClickListener {
            open(RouterKey.ModuleB.SINGLE_TYPE)
        }

        mBinding.btnMulti.setOnClickListener {
            open(RouterKey.ModuleB.MULTI_TYPE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    private fun requestMyPermissions() {
        AndPermission.with(this)
            .runtime()
            .permission(Permission.Group.STORAGE)
            .onDenied {
                finish()
            }
            .start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: SampleEvent?) {
        mBinding.btnPageb.text = event?.value ?: "PAGE_B"
    }
}