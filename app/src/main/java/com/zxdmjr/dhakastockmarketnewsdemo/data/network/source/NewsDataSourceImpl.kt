package com.zxdmjr.dhakastockmarketnewsdemo.data.network.source

import com.zxdmjr.dhakastockmarketnewsdemo.data.network.retrofit.NewsApiService
import com.zxdmjr.dhakastockmarketnewsdemo.internal.SafeApiRequest


class NewsDataSourceImpl(
    private val apiService: NewsApiService
) : SafeApiRequest(), NewsDataSource {
    override suspend fun getNews(page: String) = apiRequest {
        apiService.getNews(page)
    }
}