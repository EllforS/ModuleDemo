package com.ellfors.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.inflateBindingWithGeneric
import com.ellfors.common.app.BaseApp
import com.ellfors.common.livedata.ShareDataBus

/**
 * BaseActivity
 * 2021-03-25 16:49
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var mBinding: VB
    lateinit var mShareDataBus: ShareDataBus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = inflateBindingWithGeneric(layoutInflater)
        setContentView(mBinding.root)

        mShareDataBus = ViewModelProvider(applicationContext as BaseApp).get(ShareDataBus::class.java)

        init()
    }

    abstract fun init()
}