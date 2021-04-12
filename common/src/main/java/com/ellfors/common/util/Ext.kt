package com.ellfors.common.util

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions
import com.ellfors.common.base.BaseApplication
import com.ellfors.common.image.ImageLoader

/**
 * ARouter注入数据
 */
fun Activity.injectRouter() {
    ARouter.getInstance().inject(this)
}

/**
 * 吐司
 */
fun String?.toast(context: Context? = BaseApplication.context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this ?: "", duration).show()
}

/**
 * ARouter页面跳转
 */
fun Activity.open(path: String, requestCode: Int, build: Postcard.() -> Unit = {}) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.navigation(this, requestCode)
}

/**
 * ARouter页面跳转
 */
fun Activity.open(path: String, build: Postcard.() -> Unit = {}) {
    open(path, -1, build)
}

/**
 * ARouter页面跳转
 */
fun Context.open(path: String, build: Postcard.() -> Unit = {}) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.navigation(this)
}

/**
 * 加载图片
 */
fun ImageView.load(url: String?, options: ImageLoader.() -> Unit = {}) {
    val loader = ImageLoader.with(context).load(url)
    loader.options()
    loader.into(this)
}