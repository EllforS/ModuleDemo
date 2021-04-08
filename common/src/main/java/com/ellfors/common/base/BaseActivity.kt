package com.ellfors.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.inflateBindingWithGeneric

/**
 * BaseActivity
 * 2021-03-25 16:49
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = inflateBindingWithGeneric(layoutInflater)
        setContentView(mBinding.root)

        init()
    }

    abstract fun init()
}