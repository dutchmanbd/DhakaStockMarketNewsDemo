package com.zxdmjr.dhakastockmarketnewsdemo.data.network.model

import com.zxdmjr.dhakastockmarketnewsdemo.data.domain.model.News
import com.zxdmjr.dhakastockmarketnewsdemo.data.domain.util.DomainMapper
import javax.inject.Inject

class NewsDtoMapper @Inject constructor(
) : DomainMapper<NewsDto, News> {

    override fun mapToDomainModel(model: NewsDto) =
        News(
            content = model.content,
            group = model.group,
            isClikable = model.isClikable,
            newsUrl = model.newsUrl,
            publishDate = model.publishDate,
            scrip = model.scrip,
            source = model.source,
            title = model.title
        )

    override fun mapFromDomainModel(domainModel: News) =
        NewsDto(
            content = domainModel.content,
            group = domainModel.group,
            isClikable = domainModel.isClikable,
            newsUrl = domainModel.newsUrl,
            publishDate = domainModel.publishDate,
            scrip = domainModel.scrip,
            source = domainModel.source,
            title = domainModel.title
        )

    fun toDomainList(models: List<NewsDto>) = models.map {
        mapToDomainModel(it)
    }

    fun fromDomainList(news: List<News>) = news.map {
        mapFromDomainModel(it)
    }
}