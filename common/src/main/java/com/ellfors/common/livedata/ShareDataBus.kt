package com.ellfors.common.livedata

import androidx.lifecycle.ViewModel

/**
 * ShareViewModel
 * 2021-05-10 11:20
 */
class ShareDataBus : ViewModel() {

    val mTestText = UnPeekLiveData<String>()

}