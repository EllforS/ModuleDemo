package com.ellfors.modulea

import android.annotation.SuppressLint
import androidx.lifecycle.observe
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.base.BaseFragment
import com.ellfors.common.constants.RouterKey
import com.ellfors.common.entity.SampleARouterBean
import com.ellfors.common.util.injectRouter
import com.ellfors.common.util.open
import com.ellfors.modulea.databinding.FragmentPageABinding
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission

/**
 * PageAActivity
 * 2021-03-25 16:48
 */
@Route(path = RouterKey.ModuleA.PAGE_A)
class PageAActivity : BaseFragment<FragmentPageABinding>() {

    @JvmField
    @Autowired(name = RouterKey.ModuleA.EXTRA_TEST)
    var mSampleBean: SampleARouterBean? = null

    @SuppressLint("SetTextI18n")
    override fun init() {
//        injectRouter()

        requestMyPermissions()

        mSampleBean?.apply {
            mBinding.tvTest.text = (valueA ?: "A空") + valueB
        }

        mShareDataBus.mTestText.observe(this) {
            mBinding.btnPageb.text = it ?: "空！！！"
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

        mBinding.btnImage.setOnClickListener {
            open(RouterKey.ModuleB.IMAGE)
        }
    }

    private fun requestMyPermissions() {
        AndPermission.with(this)
            .runtime()
            .permission(Permission.Group.STORAGE)
            .onDenied {
                activity?.finish()
            }
            .start()
    }
}