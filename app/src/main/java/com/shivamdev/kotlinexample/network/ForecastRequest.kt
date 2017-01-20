package com.shivamdev.kotlinexample.network

import com.google.gson.Gson
import com.shivamdev.kotlinexample.data.ForecastResult
import java.net.URL

/**
 * Created by shivam on 20/1/17.
 */

class ForecastRequest(val zipcode: String) {
    private val APP_ID = "2ff3c33bbb1d3e9364ec233554e87205"
    private val URL = "http://api.openweathermap.org/data/2.5/" +
            "forecast/daily?mode=json&units=metric&cnt=7"
    private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="

    fun execute(): ForecastResult {
        val forecastJson = URL(COMPLETE_URL + zipcode).readText()

        return Gson().fromJson(forecastJson, ForecastResult::class.java)
    }
}