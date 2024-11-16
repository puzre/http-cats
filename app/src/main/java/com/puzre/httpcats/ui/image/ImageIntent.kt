package com.puzre.httpcats.ui.image

import com.puzre.httpcats.mvi.Intent

sealed class ImageIntent: Intent() {

    data object NoIntent: ImageIntent()

    data class OnViewCreated(val httpCodeIndex: Int?): ImageIntent()

    data object OnGetHttpCatListByIndex: ImageIntent()

    data object OnGetRandomHttpCat: ImageIntent()

    data object OnCreateUrlImage: ImageIntent()

    data class OnLoadImage(val urlImage: String): ImageIntent()

    data object OnReloadImage: ImageIntent()

    data object LoadImageSuccess: ImageIntent()

}