package com.ellfors.modulea

import android.annotation.SuppressLint
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.base.BaseActivity
import com.ellfors.common.base.BaseEvent
import com.ellfors.common.constants.RouterKey
import com.ellfors.common.entity.SampleARouterBean
import com.ellfors.common.entity.SampleEvent
import com.ellfors.common.util.injectRouter
import com.ellfors.common.util.open
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
        if (event?.getType != BaseEvent.EVENT_PAGE_A)
            return
        mBinding.btnPageb.text = event.value ?: "PAGE_B"
    }
}