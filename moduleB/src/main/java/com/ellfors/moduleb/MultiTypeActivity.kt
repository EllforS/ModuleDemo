package com.ellfors.moduleb

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.RouterKey
import com.ellfors.common.base.BaseActivity
import com.ellfors.moduleb.adapter.MultiTypeAdapter
import com.ellfors.moduleb.databinding.ActivityMultiTypeBinding
import com.ellfors.moduleb.entity.AEntity
import com.ellfors.moduleb.entity.BEntity

/**
 * MultiTypeActivity
 * 2021-04-07 18:05
 */
@Route(path = RouterKey.ModuleB.MULTI_TYPE)
class MultiTypeActivity : BaseActivity<ActivityMultiTypeBinding>() {
    override fun init() {
        mBinding.rcvMulti.apply {
            layoutManager = GridLayoutManager(this@MultiTypeActivity, 2)
            MultiTypeAdapter().apply {
                adapter = this
                setList(buildData())
            }
        }
    }

    private fun buildData(): MutableList<Any> {
        val list = mutableListOf<Any>()
        for (i in 1..10) {
            if (i % 2 == 1) {
                list.add(AEntity("${i}行"))
            } else {
                list.add(BEntity("${i}行"))
            }
        }
        return list
    }
}