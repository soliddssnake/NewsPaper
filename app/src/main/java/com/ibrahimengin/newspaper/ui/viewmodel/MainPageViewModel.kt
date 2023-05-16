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
    val newsList : LiveData<List<Article>>
        get() = _newsList

    init {
        uploadArticles()
    }

    fun uploadArticles(){
        viewModelScope.launch {
            _newsList.value = nRepo.getAllNews()
        }
    }


}

/*data class MainPageUIState(
    val loading: Boolean = false,
    val newsList: List<Any> = listOf()
)*/