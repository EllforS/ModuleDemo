package com.ellfors.moduleb

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.base.BaseActivity
import com.ellfors.common.constants.RouterKey
import com.ellfors.common.util.injectRouter
import com.ellfors.moduleb.databinding.ActivityPageBBinding


/**
 * PageBActivity
 * 2021-03-27 16:46
 */
@Route(path = RouterKey.ModuleB.PAGE_B)
class PageBActivity : BaseActivity<ActivityPageBBinding>() {

    @JvmField
    @Autowired(name = RouterKey.ModuleB.EXTRA_VALUE)
    var mValue: String? = null

    override fun init() {
        injectRouter()

        mBinding.btnBack.apply {
            text = mValue
            setOnClickListener {
                mShareDataBus.mTestText.value = "测试DataBus"
                finish()
            }
        }
    }
}