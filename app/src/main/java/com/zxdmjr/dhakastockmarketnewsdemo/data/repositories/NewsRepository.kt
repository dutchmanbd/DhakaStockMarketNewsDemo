package com.zxdmjr.dhakastockmarketnewsdemo.data.repositories

import com.zxdmjr.dhakastockmarketnewsdemo.data.domain.model.News
import com.zxdmjr.material_utils.Resource

interface NewsRepository {
    suspend fun getNews(
        page: String
    ): Resource<List<News>>
}