package com.example.fuelapi.newsapi

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

internal sealed class NewsApi : FuelRouting {

    class NewsList : NewsApi()


    override val basePath: String = "https://newsapi.org/"
    override val headers: Map<String, String>? = null
    override val method: Method
        get() {
            when (this) {
                is NewsList -> return Method.GET
            }
        }
    override val params: List<Pair<String, Any?>>? = null
        get() {
            when (this) {
                is NewsList -> return field
            }
        }
    override val path: String
        get() {
            when (this) {
                is NewsList -> return "v2/top-headlines"
            }
        }
}