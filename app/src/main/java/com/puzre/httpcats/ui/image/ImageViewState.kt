package com.puzre.httpcats.ui.image

import com.puzre.httpcats.data.HttpCode

data class ImageViewState(

    val isLoading: Boolean =  true,
    val nextIntent: ImageIntent = ImageIntent.NoIntent,
    val httpCodeIndex: Int? = null,
    val httpCode: HttpCode? = null

)