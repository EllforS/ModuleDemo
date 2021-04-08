package com.ellfors.moduleb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseBinderAdapter
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.binder.QuickItemBinder
import com.chad.library.adapter.base.binder.QuickViewBindingItemBinder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.listener.GridSpanSizeLookup
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.dylanc.viewbinding.base.inflateBindingWithGeneric
import com.ellfors.common.base.BaseRcvMultiAdapter
import com.ellfors.moduleb.R
import com.ellfors.moduleb.databinding.ItemMultiABinding
import com.ellfors.moduleb.databinding.ItemMultiBBinding
import com.ellfors.moduleb.entity.AEntity
import com.ellfors.moduleb.entity.BEntity

/**
 * MultiTypeAdapter
 * 2021-04-08 13:55
 */
class MultiTypeAdapter : BaseRcvMultiAdapter() {

    companion object {
        private const val TYPE_A = 1
        private const val TYPE_B = 2
    }

    init {
        addItemBinder(AEntity::class.java, AItemBinder())
        addItemBinder(BEntity::class.java, BItemBinder())

        setGridSpanSizeLookup { gridLayoutManager, viewType, position ->
            return@setGridSpanSizeLookup if (viewType == TYPE_A)
                2
            else
                1
        }
    }

    override fun getDefItemViewType(position: Int): Int {
        return when (data[position]) {
            is AEntity -> TYPE_A
            is BEntity -> TYPE_B
            else -> -1
        }
    }

    class AItemBinder : BaseRcvItemBinder<AEntity, ItemMultiABinding>() {
        override fun convert(holder: BinderVBHolder<ItemMultiABinding>, data: AEntity) {
            holder.viewBinding.apply {
                tvText.text = data.content
            }
        }
    }

    class BItemBinder : BaseRcvItemBinder<BEntity, ItemMultiBBinding>() {
        override fun convert(holder: BinderVBHolder<ItemMultiBBinding>, data: BEntity) {
            holder.viewBinding.apply {
                tvText.text = data.content
            }
        }
    }
}