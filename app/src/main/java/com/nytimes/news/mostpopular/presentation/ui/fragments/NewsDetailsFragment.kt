package com.nytimes.news.mostpopular.presentation.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nytimes.news.base.components.ViewModelFactory
import com.nytimes.news.mostpopular.presentation.ui.activities.NewsActivity
import com.nytimes.news.R
import com.nytimes.news.mostpopular.presentation.viewmodel.NewsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_news_details.*
import kotlinx.android.synthetic.main.news_item.view.*
import javax.inject.Inject


class NewsDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mNewsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            try {
                mNewsViewModel =
                    ViewModelProvider(
                        requireActivity(),
                        viewModelFactory
                    ).get(NewsViewModel::class.java)

                init()

            } finally {
                //empty
            }
        }
    }

    private fun init() {
        setupHeader()
        initViews()
    }

    private fun setupHeader() {
        (activity as NewsActivity).updateTitle(R.string.news_details_title)
        (activity as NewsActivity).toggleFilterAction(false)
    }

    private fun initViews() {
        mNewsViewModel.newsArticle?.let { newsArticle ->
            tvNewsTitle.text = newsArticle.title
            tvNewsDescription.text = newsArticle.abstract
            tvNewsDate.text = newsArticle.publishedDate

            Glide.with(requireActivity()?.baseContext).load(newsArticle.media.firstOrNull()?.geturl())
                .into(ivImage);

        }
    }

}
