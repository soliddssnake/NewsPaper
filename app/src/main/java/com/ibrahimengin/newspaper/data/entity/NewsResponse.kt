package com.ibrahimengin.newspaper.data.entity

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val articles: List<Article>, val status: String, val totalResults: Int
)