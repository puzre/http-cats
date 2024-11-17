package com.puzre.httpcats.data

import com.puzre.httpcats.data.model.HttpCat
import com.puzre.httpcats.data.model.Result
import com.puzre.httpcats.data.network.service.HttpCatsService

class HttpCatsRepository : IHttpCatsRepository {

    override suspend fun getClientErrorHttpCats(): Result<List<HttpCat>> {
        return HttpCatsService.instance.getClientErrorHttpCats()
    }

    override suspend fun getInformationalHttpCats(): Result<List<HttpCat>> {
        return HttpCatsService.instance.getInformationalHttpCats()
    }

    override suspend fun getRedirectionHttpCats(): Result<List<HttpCat>> {
        return HttpCatsService.instance.getRedirectionHttpCats()
    }

    override suspend fun getServerErrorHttpCats(): Result<List<HttpCat>> {
        return HttpCatsService.instance.getServerErrorHttpCats()
    }

    override suspend fun getSuccessfulHttpCats(): Result<List<HttpCat>> {
        return HttpCatsService.instance.getSuccessfulHttpCats()
    }

    companion object {
        val instance: HttpCatsRepository by lazy {
            HttpCatsRepository()
        }
    }

}