package com.shivamdev.kotlinexample.network

import android.util.Log
import java.net.URL

/**
 * Created by shivam on 19/1/17.
 */
class Request(val url : String) {

    fun run() {
        val forecastJson = URL(url).readText()
        Log.d("Forecast json : ", forecastJson)
    }
}