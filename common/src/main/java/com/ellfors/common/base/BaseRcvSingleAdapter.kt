package com.ellfors.common.base

import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ellfors.common.util.inflateBindingWithGeneric

/**
 * BaseBindingQuickAdapter
 * 2021-04-08 14:04
 */
abstract class BaseRcvSingleAdapter<T, VB : ViewBinding>(layoutResId: Int = -1) :
    BaseQuickAdapter<T, BaseRcvSingleAdapter.BaseBindingHolder>(layoutResId) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int) =
        BaseBindingHolder(inflateBindingWithGeneric<VB>(parent))

    class BaseBindingHolder(private val binding: ViewBinding) : BaseViewHolder(binding.root) {
        constructor(itemView: View) : this(ViewBinding { itemView })

        @Suppress("UNCHECKED_CAST")
        fun <VB : ViewBinding> getViewBinding() = binding as VB
    }
}