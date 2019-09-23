package com.example.fuel.room.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.fuel.room.entity.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_list LIMIT :max")
    fun getNewsList(max: Int): DataSource.Factory<Int, NewsEntity>

    @Insert(onConflict = REPLACE)
    fun insertNews(newsEntity: NewsEntity)

    @Insert(onConflict = REPLACE)
    fun updateNewsList(list: List<NewsEntity>)

    @Update(onConflict = REPLACE)
    fun updateNews(newsEntity: NewsEntity)
}