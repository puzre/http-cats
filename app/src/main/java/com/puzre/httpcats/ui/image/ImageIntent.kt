package com.puzre.httpcats.ui.image

sealed class ImageIntent {

    data object NoIntent: ImageIntent()

    data class OnSaveHttpCodeIndex(val httpCodeIndex: Int): ImageIntent()

    data object OnGetRandomHttpCode: ImageIntent()

    data object OnCreateUrlImage: ImageIntent()

    data class OnLoadImage(val urlImage: String): ImageIntent()

    data object OnReloadImage: ImageIntent()

    data object LoadImageSuccess: ImageIntent()

}