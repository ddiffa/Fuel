package com.example.fuel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.fuel.base.BaseViewModel
import com.example.fuel.repository.NewsRepository
import com.example.fuel.room.entity.NewsEntity
import org.kodein.di.generic.instance

class MainViewModel : BaseViewModel<MainViewModel>() {

    private val newsRepository by instance<NewsRepository>()
    private var liveDaoNewsEntity: LiveData<PagedList<NewsEntity>> = MutableLiveData()

    var isFirstLoad = true
    fun getNewsList(max: Int): LiveData<PagedList<NewsEntity>> {
        liveDaoNewsEntity = newsRepository.getNewsList(max)
        return liveDaoNewsEntity
    }

    fun fetchNewsList() = newsRepository.fetchNewsList()
}