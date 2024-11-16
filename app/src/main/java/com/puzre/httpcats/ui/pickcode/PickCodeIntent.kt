package com.puzre.httpcats.ui.pickcode

import com.puzre.httpcats.mvi.Intent

sealed class PickCodeIntent: Intent() {

    data object NoIntent: PickCodeIntent()

    data class OnGoToImageFragmentIntent(val httpCodeTypeIndex: Int): PickCodeIntent()

    data class OnClickHttpCodeButtonIntent(val httpCodeTypeIndex: Int): PickCodeIntent()

    data object OnResetStateIntent: PickCodeIntent()

}