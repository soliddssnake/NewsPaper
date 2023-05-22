package com.ibrahimengin.newspaper.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimengin.newspaper.data.entity.Article
import com.ibrahimengin.newspaper.data.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var nRepo: NewsRepository) : ViewModel() {
    //val newsList = MutableStateFlow()
    private var _newsList = MutableLiveData<List<Article>>()
    var pageNumber = 1
    var isLoading = MutableLiveData<Boolean>()
    var hasMorePage = true

    val newsList : LiveData<List<Article>>
        get() = _newsList

    init {
        isLoading.value = false
        uploadArticles()
    }

    fun uploadArticles(){
        isLoading.value = true
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
                isLoading.value = false
            }


        }
    }

    fun nextPage(){
        if (!isLoading.value!! && hasMorePage){
            uploadArticles()
        }
    }


}

/*data class MainPageUIState(
    val loading: Boolean = false,
    val newsList: List<Any> = listOf()
)*/