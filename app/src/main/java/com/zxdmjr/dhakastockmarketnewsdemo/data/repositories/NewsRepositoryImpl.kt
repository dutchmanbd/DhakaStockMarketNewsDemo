package com.zxdmjr.dhakastockmarketnewsdemo.data.repositories

import com.zxdmjr.dhakastockmarketnewsdemo.data.domain.model.News
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.model.NewsDtoMapper
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.source.NewsDataSource
import com.zxdmjr.material_utils.Resource

class NewsRepositoryImpl(
    private val dataSource: NewsDataSource,
    private val newsDtoMapper: NewsDtoMapper
) : NewsRepository {
    override suspend fun getNews(page: String): Resource<List<News>> {
        return when (val resource = dataSource.getNews(page)) {
            is Resource.Success -> {
                Resource.Success(newsDtoMapper.toDomainList(resource.data.newsDto))
            }
            is Resource.Loading -> {
                Resource.Loading()
            }
            is Resource.Failed -> {
                Resource.Failed(resource.errorBody, resource.message)
            }
        }
    }
}