package com.ellfors.moduleb.adapter

import com.ellfors.common.base.BaseRcvSingleAdapter
import com.ellfors.moduleb.databinding.ItemSingleTypeBinding

/**
 * SingleTypeAdapter
 * 2021-04-07 18:11
 */
class SingleTypeAdapter : BaseRcvSingleAdapter<String, ItemSingleTypeBinding>() {
    override fun convert(holder: BaseBindingHolder, item: String) {
        holder.getViewBinding<ItemSingleTypeBinding>().apply {
            tvText.text = item
        }
    }
}