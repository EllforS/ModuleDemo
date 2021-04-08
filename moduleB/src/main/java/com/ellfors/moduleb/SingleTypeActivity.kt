package com.ellfors.moduleb

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.RouterKey
import com.ellfors.common.base.BaseActivity
import com.ellfors.common.toast
import com.ellfors.moduleb.adapter.SingleTypeAdapter
import com.ellfors.moduleb.databinding.ActivitySingleTypeBinding

/**
 * SingleTypeActivity
 * 2021-04-07 18:01
 */
@Route(path = RouterKey.ModuleB.SINGLE_TYPE)
class SingleTypeActivity : BaseActivity<ActivitySingleTypeBinding>() {

    override fun init() {
        mBinding.rcvSingle.apply {
            layoutManager = LinearLayoutManager(this@SingleTypeActivity)
            SingleTypeAdapter().apply {
                adapter = this
                setNewInstance(buildData())
                setOnItemClickListener { adapter, view, position ->
                    data[position].toast()
                }
            }
        }
    }

    private fun buildData(): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 1..10) {
            list.add("${i}行")
        }
        return list
    }

}