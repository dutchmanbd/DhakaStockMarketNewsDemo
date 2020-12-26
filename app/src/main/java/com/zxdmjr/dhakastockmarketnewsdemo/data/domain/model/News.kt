package com.zxdmjr.dhakastockmarketnewsdemo.data.domain.model

data class News(
    val content: String,
    val group: String?,
    val isClikable: Boolean,
    val newsUrl: String?,
    val publishDate: String,
    val scrip: String,
    val source: String,
    val title: String
)