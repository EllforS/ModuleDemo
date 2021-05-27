package com.ellfors.moduleb

import com.alibaba.android.arouter.facade.annotation.Route
import com.ellfors.common.base.BaseFragment
import com.ellfors.common.constants.RouterKey
import com.ellfors.moduleb.databinding.FragmentBBinding

/**
 * BFragment
 * 2021-05-27 17:21
 */
@Route(path = RouterKey.ModuleB.FRAGMENT_B)
class BFragment : BaseFragment<FragmentBBinding>() {
    override fun init() {

    }
}