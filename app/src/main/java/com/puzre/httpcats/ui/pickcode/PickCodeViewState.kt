package com.puzre.httpcats.ui.pickcode

data class PickCodeViewState(
    val nextIntent: PickCodeIntent = PickCodeIntent.NoIntent,
    val isLoading: Boolean = false
)