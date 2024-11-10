package com.puzre.httpcats.data.network.service

import com.puzre.httpcats.data.model.HttpCat
import com.puzre.httpcats.data.model.Result
import com.puzre.httpcats.data.network.api.HttpCatsClient
import java.lang.Exception

class HttpCatsService : IHttpCatsService {

    private val httpCatClient = HttpCatsClient.getInstance()

    override suspend fun getClientErrorHttpCats(): Result<List<HttpCat>> {
        return try {
            val response = httpCatClient.getClientErrorHttpCats()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: listOf())
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Exception(e)
        }
    }

    override suspend fun getInformationalHttpCats(): Result<List<HttpCat>> {
        return try {
            val response = httpCatClient.getInformationalHttpCats()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: listOf())
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Exception(e)
        }
    }

    override suspend fun getRedirectionHttpCats(): Result<List<HttpCat>> {
        return try {
            val response = httpCatClient.getRedirectionHttpCats()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: listOf())
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Exception(e)
        }
    }

    override suspend fun getServerErrorHttpCats(): Result<List<HttpCat>> {
        return try {
            val response = httpCatClient.getServerErrorHttpCats()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: listOf())
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Exception(e)
        }
    }

    override suspend fun getSuccessfulHttpCats(): Result<List<HttpCat>> {
        return try {
            val response = httpCatClient.getSuccessfulHttpCats()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: listOf())
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Exception(e)
        }
    }

    companion object {
        val instance: HttpCatsService by lazy {
            HttpCatsService()
        }
    }

}