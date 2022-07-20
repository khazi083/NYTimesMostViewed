package com.nytimes.news.mostpopular.di


import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.nytimes.news.mostpopular.data.remote.source.NewsRemoteDataSource
import com.nytimes.news.mostpopular.data.remote.source.NewsRemoteDataSourceImpl
import com.nytimes.news.mostpopular.data.remote.services.NewsService


@Module(includes = [NewsRemoteModule.Binders::class])
class NewsRemoteModule {

    @Module
    interface Binders {
        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: NewsRemoteDataSourceImpl
        ): NewsRemoteDataSource
    }

    @Provides
    fun providesNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)


}