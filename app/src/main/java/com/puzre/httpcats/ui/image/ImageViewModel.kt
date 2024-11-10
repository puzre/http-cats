package com.puzre.httpcats.ui.image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puzre.httpcats.data.model.HttpCat
import com.puzre.httpcats.data.HttpCatsRepository

class ImageViewModel: ViewModel() {

    private val allHttpCodesList = HttpCatsRepository.getAllCodes()
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

        val urlImage = "https://http.cat/${viewState.value!!.httpCat!!.code}.jpg"

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
        var httpCat: HttpCat

        do {

            randomSubIndex = (0..<allHttpCodesList[viewState.value!!.httpCodeIndex!!].size).random()
            httpCat = allHttpCodesList[viewState.value!!.httpCodeIndex!!][randomSubIndex]

        }while(viewState.value!!.httpCat != null && viewState.value!!.httpCat!!.code == httpCat.code)


        viewState.postValue(
            viewState.value!!.copy(
                nextIntent = ImageIntent.OnCreateUrlImage,
                httpCat = httpCat
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