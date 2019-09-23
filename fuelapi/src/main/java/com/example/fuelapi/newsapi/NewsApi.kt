package com.example.fuelapi.newsapi

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

internal sealed class NewsApi : FuelRouting {

    class NewsList : NewsApi()


    override val basePath: String = "https://newsapi.org"
    override val headers: Map<String, String>? = null
    override val method: Method
        get() {
            when (this) {
                is NewsList -> return Method.GET
            }
        }
    override val params: List<Pair<String, Any?>>?
        get() {
            return when (this) {
                is NewsList -> listOf(
                    "sources" to "techcrunch",
                    "apiKey" to "efd67bbc1d024b32a17469d00124ec15"
                )
            }
        }
    override val path: String
        get() {
            return when (this) {
                is NewsList -> "/v2/top-headlines"
            }
        }


}