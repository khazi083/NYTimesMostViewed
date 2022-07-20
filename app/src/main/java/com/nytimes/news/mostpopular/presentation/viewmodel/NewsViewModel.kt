package com.nytimes.news.mostpopular.presentation.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nytimes.news.base.constants.Period
import com.nytimes.news.base.models.APIResponse
import com.nytimes.news.mostpopular.data.models.NewsArticle
import com.nytimes.news.mostpopular.data.repository.NewsRepo
import kotlinx.coroutines.launch
import javax.inject.Inject



class NewsViewModel @Inject constructor(private val mNewsRepository: NewsRepo) : ViewModel() {

    val newsResult = MediatorLiveData<APIResponse<List<NewsArticle>>>()
    var newsArticle: NewsArticle? = null

    fun getNewsArticlesAysnc(period: Period = Period.DAILY, forceNetwork: Boolean = false) {
        viewModelScope.launch {

            newsResult.addSource(mNewsRepository.getNewsArticlesAsync(period, forceNetwork)) {
                newsResult.value = it
            }
        }
    }

}