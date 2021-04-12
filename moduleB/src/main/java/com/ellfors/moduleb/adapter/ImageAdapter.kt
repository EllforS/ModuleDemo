package com.ellfors.moduleb.adapter

import com.ellfors.common.base.BaseRcvSingleAdapter
import com.ellfors.common.util.load
import com.ellfors.moduleb.R
import com.ellfors.moduleb.databinding.ItemImageBinding
import com.ellfors.moduleb.entity.ImageEntity

/**
 * ImageAdapter
 * 2021-04-12 16:11
 */
class ImageAdapter : BaseRcvSingleAdapter<ImageEntity, ItemImageBinding>() {

    override fun convert(holder: BaseBindingHolder, item: ImageEntity) {
        holder.getViewBinding<ItemImageBinding>().apply {
            when (item.type) {
                0 -> ivImage.load(item.url)
                1 -> ivImage.load(item.url) {
                    CIRCLE_CROP()
                }
                2 -> ivImage.load(item.url) {
                    FIT_CENTER()
                }
                3 -> ivImage.load("") {
                    placeholder(R.mipmap.ic_launcher)
                    error(R.drawable.ic_error)
                }
            }
        }
    }
}