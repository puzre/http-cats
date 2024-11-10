package com.puzre.httpcats.ui.pickcode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.puzre.httpcats.mvi.Lse

class PickCodeViewModel : ViewModel() {

    private var currentViewState = PickCodeViewState()
    private val resultIntent = MutableLiveData<Lse<PickCodeResultIntent>>()
    val viewState: LiveData<PickCodeViewState> = resultIntent.map { castResultIntent(it) }

    private fun castResultIntent(resultIntent: Lse<PickCodeResultIntent>): PickCodeViewState {

        currentViewState = when (resultIntent) {

            is Lse.Loading -> {

                currentViewState.copy(
                    nextIntent = PickCodeIntent.NoIntent,
                    isLoading = true
                )
            }

            is Lse.Success -> {
                when (resultIntent.intent) {

                    is PickCodeResultIntent.ResetStateResult -> {
                        currentViewState.copy(
                            nextIntent = PickCodeIntent.NoIntent,
                            isLoading = false
                        )
                    }

                    is PickCodeResultIntent.ClickHttpCodeButtonResult -> {
                        currentViewState.copy(
                            nextIntent = PickCodeIntent.OnGoToImageFragmentIntent(
                                httpCodeTypeIndex = resultIntent.intent.httpCodeTypeIndex
                            ),
                            isLoading = false
                        )
                    }
                }
            }

            is Lse.Error -> {
                when (resultIntent.intent) {

                    else -> {
                        currentViewState.copy(
                            nextIntent = PickCodeIntent.NoIntent,
                            isLoading = false
                        )
                    }
                }
            }

        }

        return currentViewState

    }

    fun onIntent(intent: PickCodeIntent) {

        when (intent) {

            is PickCodeIntent.OnClickHttpCodeButtonIntent -> clickHttpCodeButton(intent.httpCodeTypeIndex)
            is PickCodeIntent.OnResetStateIntent -> resetState()
            else -> {}

        }

    }

    private fun resetState() {
        resultIntent.postValue(
            Lse.Success(
                PickCodeResultIntent.ResetStateResult
            )
        )
    }

    private fun clickHttpCodeButton(httpCodeTypeIndex: Int) {
        resultIntent.postValue(
            Lse.Success(
                PickCodeResultIntent.ClickHttpCodeButtonResult(
                    httpCodeTypeIndex = httpCodeTypeIndex
                )
            )
        )
    }

}