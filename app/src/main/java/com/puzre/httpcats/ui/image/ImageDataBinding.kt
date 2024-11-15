package com.puzre.httpcats.ui.image

import com.puzre.httpcats.data.model.HttpCat

data class ImageDataBinding(
    val httpCodeIndex: Int? = null,
    val randomHttpCat: HttpCat? = null,
    val httpCatList: List<HttpCat> = listOf()
)
