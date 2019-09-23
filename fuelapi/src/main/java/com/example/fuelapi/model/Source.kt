package com.example.fuelapi.model

import com.beust.klaxon.Json

data class Source(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String
)