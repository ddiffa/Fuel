package com.example.fuelapi

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request

class Api {

    private fun request(api : Fuel.RequestConvertible): Request {

        return request(api).timeout(30000)
    }

}