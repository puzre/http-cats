package com.puzre.httpcats.ui.image

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.puzre.httpcats.data.HttpCatsRepository
import com.puzre.httpcats.data.model.HttpCat
import com.puzre.httpcats.mvi.Lse

class ImageViewModel : ViewModel() {

    private var currentViewState = ImageViewState()
    private val resultIntent = MutableLiveData<Lse<ImageResultIntent>>()

    val viewState: LiveData<ImageViewState> = resultIntent.map { castResultIntent(it) }

    private fun castResultIntent(resultIntent: Lse<ImageResultIntent>): ImageViewState {

        currentViewState = when (resultIntent) {

            is Lse.Loading -> {
                currentViewState.copy(
                    isLoading = true,
                    nextIntent = ImageIntent.NoIntent
                )
            }

            is Lse.Success -> {
                when (resultIntent.intent) {

                    is ImageResultIntent.GetRandomHttpCat -> {
                        currentViewState.copy(
                            isLoading = false,
                            nextIntent = ImageIntent.NoIntent,
                            dataBinding = currentViewState.dataBinding.copy(
                                randomHttpCat = resultIntent.intent.randomHttpCat
                            )
                        )
                    }

                    is ImageResultIntent.GetHttpCatsListByIndex -> {
                        currentViewState.copy(
                            isLoading = false,
                            nextIntent = ImageIntent.OnGetRandomHttpCat,
                            dataBinding = currentViewState.dataBinding.copy(
                                httpCatList = resultIntent.intent.httpCatList
                            )
                        )
                    }

                    is ImageResultIntent.ViewCreatedResultIntent -> {
                        currentViewState.copy(
                            isLoading = false,
                            nextIntent = ImageIntent.OnGetHttpCatListByIndex,
                            dataBinding = currentViewState.dataBinding.copy(
                                httpCodeIndex = resultIntent.intent.httpCodeIndex
                            )
                        )
                    }
                }
            }

            is Lse.Error -> {
                when (resultIntent.intent) {
                    else -> {
                        currentViewState.copy(
                            isLoading = false,
                            nextIntent = ImageIntent.NoIntent
                        )
                    }
                }
            }

        }

        return currentViewState

    }

    fun onIntent(intent: ImageIntent) {

        when (intent) {

            is ImageIntent.OnViewCreated -> viewCreated(intent.httpCodeIndex)
            is ImageIntent.OnGetHttpCatListByIndex -> getHttpCatListByIndex()
            is ImageIntent.OnGetRandomHttpCat -> getRandomHttpCat()
            else -> {}

        }

    }

    private fun getHttpCatListByIndex() {
        resultIntent.postValue(
            Lse.Success(
                ImageResultIntent.GetHttpCatsListByIndex(
                    httpCatList = HttpCatsRepository.getAllCodes()[currentViewState.dataBinding.httpCodeIndex
                        ?: 0]
                )
            )
        )
    }

    private fun viewCreated(httpCodeIndex: Int?) {
        resultIntent.postValue(
            Lse.Success(
                ImageResultIntent.ViewCreatedResultIntent(
                    httpCodeIndex = httpCodeIndex
                )
            )
        )
    }

    private fun getRandomHttpCat() {

        val randomIndex = (0..<currentViewState.dataBinding.httpCatList.size).random()
        val randomHttpCat = currentViewState.dataBinding.httpCatList[randomIndex]

        resultIntent.postValue(
            Lse.Success(
                ImageResultIntent.GetRandomHttpCat(
                    randomHttpCat = randomHttpCat
                )
            )
        )

    }

}