package com.example.fuelapi.model

import com.beust.klaxon.Json

class Article(
    @Json(name = "source") val source: Source,
    @Json(name = "author") val author: String,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String,
    @Json(name = "url") val url: String,
    @Json(name = "urlToImage") val urlToImage: String,
    @Json(name = "publishedAt") val publishedAt: String
)