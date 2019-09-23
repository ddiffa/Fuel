package com.example.fuelapi.model

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.ResponseDeserializable

data class ArticleResponse(
    @Json(name = "status") val status: String,
    @Json(name = "totalResults") val totalResults: Int,
    @Json(name = "articles") val listOfArticle: List<Article> = listOf()
) {
    class Deserializer : ResponseDeserializable<ArticleResponse> {
        override fun deserialize(content: String) = Klaxon().parse<ArticleResponse>(content)
    }
}