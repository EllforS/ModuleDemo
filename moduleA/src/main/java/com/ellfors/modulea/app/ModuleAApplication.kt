package com.ellfors.modulea.app

import android.app.Application
import android.util.Log
import com.ellfors.common.app.IApp

/**
 * ModuleAApplication
 * 2021-04-13 10:03
 */
class ModuleAApplication : IApp {

    override fun initApp(application: Application) {
        Log.d("AAAA", "Module A Application init")
    }
}