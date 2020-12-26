package com.zxdmjr.dhakastockmarketnewsdemo.data.network.respones


import com.google.gson.annotations.SerializedName
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.model.NewsDto

data class NewsResponse(
    @SerializedName("JsonRequestBehavior")
    val jsonRequestBehavior: Int,
    @SerializedName("Data")
    val newsDto: List<NewsDto> = emptyList(),
    @SerializedName("MaxJsonLength")
    val maxJsonLength: Int
)