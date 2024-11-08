package com.puzre.httpcats.data.network.api

import com.puzre.httpcats.core.RetrofitHelper

object HttpCatsClient {
    fun getInstance(): HttpCatsApi {
        return RetrofitHelper.getInstance().create(HttpCatsApi::class.java)
    }
}