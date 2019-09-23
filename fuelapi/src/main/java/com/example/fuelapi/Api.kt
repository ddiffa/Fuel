package com.example.fuelapi

import com.example.fuelapi.model.ArticleResponse
import com.example.fuelapi.newsapi.NewsApi
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.livedata.liveDataObject

class Api {

    private fun request(api: Fuel.RequestConvertible): Request {

        return Fuel.request(api).timeout(3000)
    }

    fun getNewsList() = request(NewsApi.NewsList()).liveDataObject(ArticleResponse.Deserializer())
}