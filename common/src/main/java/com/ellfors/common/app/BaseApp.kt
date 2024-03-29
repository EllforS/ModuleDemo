package com.ellfors.common.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.alibaba.android.arouter.launcher.ARouter
import com.ellfors.common.BuildConfig
import com.ellfors.common.livedata.ShareDataBus
import java.lang.Exception

/**
 * BaseApplication
 * 2021-03-25 16:51
 */
open class BaseApp : Application(), ViewModelStoreOwner {

    private val mAppList = mutableListOf(
        "com.ellfors.modulea.app.ModuleAApplication",
        "com.ellfors.moduleb.app.ModuleBApplication"
    )

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    private val mViewModelStore: ViewModelStore by lazy {
        ViewModelStore()
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        initData()
        modulesAppInit()
    }

    private fun initData() {

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    /**
     * 通过反射方法找到对应的类，并调用接口
     */
    private fun modulesAppInit() {
        for (moduleImpl in mAppList) {
            try {
                val clazz = Class.forName(moduleImpl)
                val obj = clazz.newInstance()
                if (obj is IApp)
                    obj.initApp(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getViewModelStore(): ViewModelStore {
        return mViewModelStore
    }
}