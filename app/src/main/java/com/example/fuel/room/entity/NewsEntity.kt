package com.example.fuel.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fuelapi.model.Article
import com.example.fuelapi.model.ArticleResponse
import com.example.fuelapi.model.Source

@Entity(tableName = "news_list")
class NewsEntity {

    @PrimaryKey
    @ColumnInfo(name = "title")
    var title: String = ""
    @ColumnInfo(name = "description")
    var description: String = ""
    @ColumnInfo(name = "url")
    var url: String = ""
    @ColumnInfo(name = "urlToImage")
    var urlToImage: String = ""
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String = ""
    @ColumnInfo(name = "source")
    var source: Source? = null

    fun fromNewsData(news: Article): NewsEntity {
        title = news.title
        description = news.description
        url = news.url
        urlToImage = news.urlToImage
        publishedAt = news.publishedAt
        source = news.source
        return this
    }

    companion object {
        fun fromNewsList(articleResponse: ArticleResponse): List<NewsEntity> =
            articleResponse.listOfArticle.map { data -> NewsEntity().fromNewsData(data) }
    }
}