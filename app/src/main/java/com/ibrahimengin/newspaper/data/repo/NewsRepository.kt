package com.ibrahimengin.newspaper.data.repo

import com.ibrahimengin.newspaper.data.entity.Article
import com.ibrahimengin.newspaper.retrofit.NewsWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(var newsWebService: NewsWebService) {

    suspend fun getAllNews() : List<Article> {
        return withContext(Dispatchers.IO) {
            newsWebService.getNews().articles
        }
    }
}