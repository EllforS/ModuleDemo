package com.ellfors.common.image

/**
 * ImageOptions
 * 2021-04-12 17:40
 */
class ImageOptions {
    var url: String? = null
    var type: TYPE? = TYPE.CENTER_CROP
    var error: Int = 0
    var placeholder: Int = 0

    enum class TYPE {
        CENTER_CROP,
        CIRCLE_CROP,
        FIT_CENTER,
        CENTER_INSIDE
    }
}