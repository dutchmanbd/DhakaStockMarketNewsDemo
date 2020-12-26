package com.zxdmjr.dhakastockmarketnewsdemo.data.network.retrofit

import com.zxdmjr.dhakastockmarketnewsdemo.data.network.respones.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiService {

    @GET("api/feed/news/{page}")
    suspend fun getNews(
        @Path("page") page: String
    ): Response<NewsResponse>
}