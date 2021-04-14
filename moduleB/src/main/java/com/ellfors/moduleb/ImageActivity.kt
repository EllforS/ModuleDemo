package com.ellfors.moduleb

import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.base.BaseActivity
import com.ellfors.common.constants.RouterKey
import com.ellfors.moduleb.adapter.ImageAdapter
import com.ellfors.moduleb.databinding.ActivityImageBinding
import com.ellfors.moduleb.entity.ImageEntity

/**
 * ImageActivity
 * 2021-04-12 16:07
 */
@Route(path = RouterKey.ModuleB.IMAGE, extras = 1)
class ImageActivity : BaseActivity<ActivityImageBinding>() {

    override fun init() {
        mBinding.rcvImg.apply {
            layoutManager = GridLayoutManager(this@ImageActivity, 2)
            val adapter = ImageAdapter()
            this.adapter = adapter
            adapter.setList(buildData())
        }
    }

    private fun buildData(): MutableList<ImageEntity> {
        val list = mutableListOf<ImageEntity>()
        list.add(ImageEntity(0))
        list.add(ImageEntity(1))
        list.add(ImageEntity(2))
        list.add(ImageEntity(3))
        return list
    }

}