package com.puzre.httpcats.data

import com.puzre.httpcats.data.model.HttpCat
import com.puzre.httpcats.data.model.Result

interface IHttpCatsRepository {

    suspend fun getClientErrorHttpCats(): Result<List<HttpCat>>

    suspend fun getInformationalHttpCats(): Result<List<HttpCat>>

    suspend fun getRedirectionHttpCats(): Result<List<HttpCat>>

    suspend fun getServerErrorHttpCats(): Result<List<HttpCat>>

    suspend fun getSuccessfulHttpCats(): Result<List<HttpCat>>

}