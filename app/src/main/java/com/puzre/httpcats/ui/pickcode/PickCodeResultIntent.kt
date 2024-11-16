package com.puzre.httpcats.ui.pickcode

import com.puzre.httpcats.mvi.ResultIntent

sealed class PickCodeResultIntent: ResultIntent() {

    data class ClickHttpCodeButtonResult(val httpCodeTypeIndex: Int): PickCodeResultIntent()

    data object ResetStateResult: PickCodeResultIntent()

}
