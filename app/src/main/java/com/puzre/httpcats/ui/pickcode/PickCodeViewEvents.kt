package com.puzre.httpcats.ui.pickcode

import android.view.View

interface PickCodeViewEvents {
    fun onClickInformational(view: View)
    fun onClickSuccessful(view: View)
    fun onClickRedirection(view: View)
    fun onClickClientError(view: View)
    fun onClickServerError(view: View)
}