package com.puzre.httpcats.ui.image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puzre.httpcats.data.HttpCode
import com.puzre.httpcats.data.HttpCodesRepository

class ImageViewModel: ViewModel() {

    private val allHttpCodesList = HttpCodesRepository.getAllCodes()
    val viewState = MutableLiveData(ImageViewState())

    fun onIntent(intent: ImageIntent){

        when(intent){

            is ImageIntent.OnSaveHttpCodeIndex -> saveHttpCode(intent.httpCodeIndex)
            is ImageIntent.OnGetRandomHttpCode -> getRandomHttpCode()
            is ImageIntent.OnCreateUrlImage -> createUrlImage()
            is ImageIntent.LoadImageSuccess -> loadImageSuccess()
            is ImageIntent.OnReloadImage -> reloadImage()
            else -> {}

        }

    }

    private fun loadImageSuccess() {

        viewState.postValue(
            viewState.value!!.copy(
                isLoading = false,
                nextIntent = ImageIntent.NoIntent
            )
        )

    }

    private fun createUrlImage() {

        val urlImage = "https://http.cat/${viewState.value!!.httpCode!!.code}.jpg"

        viewState.postValue(
            viewState.value!!.copy(
                nextIntent = ImageIntent.OnLoadImage(urlImage)
            )
        )

    }

    private fun saveHttpCode(httpCodeIndex: Int) {

        viewState.postValue(
            viewState.value!!.copy(
                nextIntent = ImageIntent.OnGetRandomHttpCode,
                httpCodeIndex = httpCodeIndex
            )
        )

    }

    private fun getRandomHttpCode(){

        var randomSubIndex: Int?
        var httpCode: HttpCode

        do {

            randomSubIndex = (0..<allHttpCodesList[viewState.value!!.httpCodeIndex!!].size).random()
            httpCode = allHttpCodesList[viewState.value!!.httpCodeIndex!!][randomSubIndex]

        }while(viewState.value!!.httpCode != null && viewState.value!!.httpCode!!.code == httpCode.code)


        viewState.postValue(
            viewState.value!!.copy(
                nextIntent = ImageIntent.OnCreateUrlImage,
                httpCode = httpCode
            )
        )

    }

    private fun reloadImage(){

        viewState.postValue(
            viewState.value!!.copy(
                isLoading = true,
                nextIntent = ImageIntent.OnGetRandomHttpCode
            )
        )

    }

}