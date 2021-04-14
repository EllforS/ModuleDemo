package com.ellfors.common.router

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.ellfors.common.constants.RouterKey
import com.ellfors.common.util.open

/**
 * ARouter 跳转拦截器
 * 2021-04-13 17:10
 */
@Interceptor(priority = 10, name = "测试拦截器")
class TestInterceptor : IInterceptor {
    override fun init(context: Context?) {

    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
//        if (postcard?.extra == 1) {
//            callback?.onInterrupt(null)
//            open(RouterKey.ModuleB.PAGE_B) {
//                withString(RouterKey.ModuleB.EXTRA_VALUE, "拦截的参数")
//            }
//        } else {
            callback?.onContinue(postcard)
//        }
    }
}