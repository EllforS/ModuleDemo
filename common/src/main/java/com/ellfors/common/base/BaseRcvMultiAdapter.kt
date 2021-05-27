package com.ellfors.common.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseBinderAdapter
import com.chad.library.adapter.base.binder.QuickViewBindingItemBinder
import com.ellfors.common.util.inflateBindingWithGeneric

/**
 * BaseRcvMultiAdapter
 * 2021-04-08 15:06
 */
abstract class BaseRcvMultiAdapter : BaseBinderAdapter() {

    abstract class BaseRcvItemBinder<T, VB : ViewBinding> :
        QuickViewBindingItemBinder<T, VB>() {
        override fun onCreateViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): VB {
            return inflateBindingWithGeneric(layoutInflater, parent, false)
        }
    }
}