package com.ellfors.common.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.ellfors.common.BuildConfig

/**
 * BaseApplication
 * 2021-03-25 16:51
 */
open class BaseApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}