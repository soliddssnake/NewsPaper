package com.ibrahimengin.newspaper.di

import com.ibrahimengin.newspaper.data.repo.NewsRepository
import com.ibrahimengin.newspaper.retrofit.ApiUtils
import com.ibrahimengin.newspaper.retrofit.NewsWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideNewsDaoRepository(newsWebService: NewsWebService) : NewsRepository {
        return NewsRepository(newsWebService)
    }

    @Provides
    @Singleton
    fun provideNewsWebService() : NewsWebService {
        return Retrofit.Builder().baseUrl(ApiUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsWebService::class.java)
    }






}