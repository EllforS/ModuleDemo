package com.ellfors.moduleb.entity

/**
 * RcvEntity
 * 2021-04-08 13:52
 */
data class AEntity(
    var content: String? = null,
)

data class BEntity(
    var content: String? = null,
)

data class ImageEntity(
    var type: Int = 0,
    var url: String = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3663359702,1992818410&fm=26&gp=0.jpg"
)