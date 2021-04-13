package com.ellfors.moduleb.app

import android.app.Application
import android.util.Log
import com.ellfors.common.app.IApp

/**
 * ModuleBApplication
 * 2021-04-12 18:29
 */
class ModuleBApplication : IApp {

    override fun initApp(application: Application) {
        Log.d("AAAA", "Module B Application init")
    }
}