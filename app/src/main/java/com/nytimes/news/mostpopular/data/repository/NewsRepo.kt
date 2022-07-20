package com.nytimes.news.mostpopular.data.repository

import androidx.lifecycle.liveData
import com.nytimes.news.base.caching.LocalDatabaseTypeConverter
import com.nytimes.news.base.constants.Period
import com.nytimes.news.base.models.APIResponse
import com.nytimes.news.mostpopular.data.local.NewsArticleEntity
import com.nytimes.news.mostpopular.data.local.NewsLocalDataSource
import com.nytimes.news.mostpopular.data.models.NewsArticle
import javax.inject.Inject
import com.nytimes.news.mostpopular.data.remote.source.NewsRemoteDataSource


class NewsRepo @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource,
    private val localDatabaseTypeConverter: LocalDatabaseTypeConverter
)  {

     suspend fun getNewsArticlesAsync(
        period: Period,
        forceNetwork: Boolean
    ) = liveData {
        emit(APIResponse.loading())
        try {

            var articles: List<NewsArticle>? = null

            if (!forceNetwork) {
                articles = localDataSource.getNewsArticles(period)
            }


            if (articles.isNullOrEmpty()) {
                articles = remoteDataSource.getNewsArticlesAsync(period)
                val newsArticleEntity =
                    NewsArticleEntity(
                        period.value,
                        localDatabaseTypeConverter.fromNewsArticlews(articles)
                    )
                localDataSource.saveAllNews(newsArticleEntity)
            }

            emit(APIResponse.success(articles))

        } catch (exception: Exception) {
            emit(APIResponse.error(exception))
        }
    }


}