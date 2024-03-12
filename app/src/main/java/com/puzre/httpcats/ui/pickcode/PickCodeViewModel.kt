package com.puzre.httpcats.ui.pickcode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PickCodeViewModel: ViewModel() {

    val viewState = MutableLiveData(PickCodeViewState())

    fun onIntent(intent: PickCodeIntent){

        when(intent){

            is PickCodeIntent.OnClickHttpCodeButton -> clickHttpCodeButton(intent.nextIntent)
            else -> {}

        }

    }

    private fun clickHttpCodeButton(nextIntent: PickCodeIntent) {

        viewState.postValue(
            viewState.value!!.copy(
                nextIntent = nextIntent
            )
        )

    }

}