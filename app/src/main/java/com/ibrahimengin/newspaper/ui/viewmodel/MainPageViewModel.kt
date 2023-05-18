package com.ibrahimengin.newspaper.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimengin.newspaper.data.entity.Article
import com.ibrahimengin.newspaper.data.entity.NewsResponse
import com.ibrahimengin.newspaper.data.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var nRepo: NewsRepository) : ViewModel() {
    //val newsList = MutableStateFlow()
    private var _newsList = MutableLiveData<List<Article>>()
    var pageNumber = 1
    var isLoading = false
    var hasMorePage = true

    val newsList : LiveData<List<Article>>
        get() = _newsList

    init {
        uploadArticles()
    }

    fun uploadArticles(){
        isLoading = true
        viewModelScope.launch {
            try {
                val articles = nRepo.getAllNews(pageNumber)
                if (articles.isNotEmpty()) {
                    pageNumber++
                    _newsList.value = _newsList.value.orEmpty() + articles
                }else {
                    hasMorePage = false
                }
            }catch (_: Exception){

            }finally {
                isLoading = false
            }


        }
    }

    fun nextPage(){
        if (!isLoading && hasMorePage){
            uploadArticles()
        }
    }


}

/*data class MainPageUIState(
    val loading: Boolean = false,
    val newsList: List<Any> = listOf()
)*/