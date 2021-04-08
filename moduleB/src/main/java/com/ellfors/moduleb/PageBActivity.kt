package com.ellfors.moduleb

import android.annotation.SuppressLint
import android.webkit.WebSettings
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.*
import com.ellfors.common.base.BaseActivity
import com.ellfors.moduleb.databinding.ActivityPageBBinding
import org.greenrobot.eventbus.EventBus


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
                EventBus.getDefault().post(SampleEvent(3, "回调"))
                finish()
            }
        }
    }
}