package com.zxdmjr.dhakastockmarketnewsdemo.data.network.model

import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("Content")
    val content: String,
    @SerializedName("Group")
    val group: String?,
    @SerializedName("IsClikable")
    val isClikable: Boolean,
    @SerializedName("NewsUrl")
    val newsUrl: String?,
    @SerializedName("PublishDate")
    val publishDate: String,
    @SerializedName("Scrip")
    val scrip: String,
    @SerializedName("Source")
    val source: String,
    @SerializedName("Title")
    val title: String
)