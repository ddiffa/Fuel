package com.example.fuel.repository

import android.content.Context
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.fuel.base.BaseRepository
import com.example.fuel.room.dao.NewsDao
import com.example.fuel.room.entity.NewsEntity
import com.example.fuelapi.Api
import org.kodein.di.generic.instance

class NewsRepository(private val context: Context) :
    BaseRepository<NewsRepository>(context = context) {
    private val api by instance<Api>()
    private val newsDao by instance<NewsDao>()
    val pagingConfig = PagedList.Config.Builder()
        .setPageSize(10)
        .build()

    fun getNewsList(max: Int) = LivePagedListBuilder(newsDao.getNewsList(max), pagingConfig).build()
    fun fetchNewsList() {
        api.getNewsList().observeForever({ result ->
            if (result != null) {
                val (data, error) = result
                if (data != null) {
                    newsDao.updateNewsList(NewsEntity.fromNewsList(data))
                }
            }
        })
    }
}