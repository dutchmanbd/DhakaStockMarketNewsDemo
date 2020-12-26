package com.zxdmjr.dhakastockmarketnewsdemo.data.network.source

import com.zxdmjr.dhakastockmarketnewsdemo.data.network.respones.NewsResponse
import com.zxdmjr.material_utils.Resource

interface NewsDataSource {

    suspend fun getNews(
        page: String
    ): Resource<NewsResponse>
}