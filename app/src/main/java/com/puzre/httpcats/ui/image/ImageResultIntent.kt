package com.puzre.httpcats.ui.image

import com.puzre.httpcats.data.model.HttpCat
import com.puzre.httpcats.mvi.ResultIntent

sealed class ImageResultIntent: ResultIntent() {

    data class ViewCreatedResultIntent(val httpCodeIndex: Int?): ImageResultIntent()

    data class GetHttpCatsListByIndex(val httpCatList: List<HttpCat>): ImageResultIntent()

    data class GetRandomHttpCat(val randomHttpCat: HttpCat): ImageResultIntent()

}
