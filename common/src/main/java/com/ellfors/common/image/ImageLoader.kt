package com.ellfors.common.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * ImageLoader
 * 2021-04-12 17:39
 */
class ImageLoader(private val mContext: Context) {

    companion object {
        fun with(context: Context): ImageLoader {
            return ImageLoader(context)
        }
    }

    private val mOptions: ImageOptions by lazy {
        ImageOptions()
    }

    fun load(url: String?): ImageLoader {
        mOptions.url = url
        return this
    }

    fun CENTER_CROP(): ImageLoader {
        mOptions.type = ImageOptions.TYPE.CENTER_CROP
        return this
    }

    fun CIRCLE_CROP(): ImageLoader {
        mOptions.type = ImageOptions.TYPE.CIRCLE_CROP
        return this
    }

    fun FIT_CENTER(): ImageLoader {
        mOptions.type = ImageOptions.TYPE.FIT_CENTER
        return this
    }

    fun CENTER_INSIDE(): ImageLoader {
        mOptions.type = ImageOptions.TYPE.CENTER_INSIDE
        return this
    }

    fun placeholder(placeholder: Int): ImageLoader {
        mOptions.placeholder = placeholder
        return this
    }

    fun error(error: Int): ImageLoader {
        mOptions.error = error
        return this
    }

    fun into(imageView: ImageView) {
        create(imageView)
    }

    private fun create(imageView: ImageView) {
        val options = when (mOptions.type) {
            ImageOptions.TYPE.CENTER_CROP -> RequestOptions.centerCropTransform()
            ImageOptions.TYPE.CIRCLE_CROP -> RequestOptions.circleCropTransform()
            ImageOptions.TYPE.FIT_CENTER -> RequestOptions.fitCenterTransform()
            ImageOptions.TYPE.CENTER_INSIDE -> RequestOptions.centerInsideTransform()
            else -> RequestOptions.centerCropTransform()
        }
        Glide.with(mContext)
            .load(mOptions.url)
            .apply(options.placeholder(mOptions.placeholder).error(mOptions.error))
            .into(imageView)
    }
}