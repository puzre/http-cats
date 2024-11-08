package com.puzre.httpcats.data.network.api

import com.puzre.httpcats.data.model.HttpCat
import retrofit2.Response
import retrofit2.http.GET

interface HttpCatsApi {

    @GET("client-error.json")
    suspend fun getClientErrorHttpCats(): Response<List<HttpCat>>

    @GET("informational.json")
    suspend fun getInformationalHttpCats(): Response<List<HttpCat>>

    @GET("redirection.json")
    suspend fun getRedirectionHttpCats(): Response<List<HttpCat>>

    @GET("server-error.json")
    suspend fun getServerErrorHttpCats(): Response<List<HttpCat>>

    @GET("successful.json")
    suspend fun getSuccessfulHttpCats(): Response<List<HttpCat>>

}