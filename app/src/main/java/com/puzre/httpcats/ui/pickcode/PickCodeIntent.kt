package com.puzre.httpcats.ui.pickcode

sealed class PickCodeIntent {

    data object NoIntent: PickCodeIntent()

    data class OnGoToImageFragment(val httpCodeIndex: Int): PickCodeIntent()

    data class OnClickHttpCodeButton(val nextIntent: PickCodeIntent): PickCodeIntent()

}