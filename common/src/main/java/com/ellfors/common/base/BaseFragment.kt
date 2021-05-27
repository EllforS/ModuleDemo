package com.ellfors.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.ellfors.common.app.BaseApp
import com.ellfors.common.livedata.ShareDataBus
import com.ellfors.common.util.inflateBindingWithGeneric

/**
 * BaseFragment
 * 2021-04-02 17:47
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    lateinit var mShareDataBus: ShareDataBus

    val mBinding: VB
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflateBindingWithGeneric(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mShareDataBus = ViewModelProvider(activity?.applicationContext as BaseApp).get(ShareDataBus::class.java)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun init()
}