package com.ibrahimengin.newspaper.retrofit

import com.ibrahimengin.newspaper.data.entity.NewsResponse
import com.ibrahimengin.newspaper.retrofit.ApiUtils.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsWebService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = API_KEY //interceptor ile yapılabilir
    ): NewsResponse
}