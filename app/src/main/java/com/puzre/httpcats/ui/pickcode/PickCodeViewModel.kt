package com.puzre.httpcats.ui.pickcode

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzre.httpcats.data.network.service.HttpCatsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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