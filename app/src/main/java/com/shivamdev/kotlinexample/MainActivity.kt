package com.shivamdev.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.shivamdev.kotlinexample.domain.model.Forecast
import com.shivamdev.kotlinexample.forecast.ForecastAdapter
import com.shivamdev.kotlinexample.listeners.OnItemClickListener
import com.shivamdev.kotlinexample.network.RequestForecastCommand
import com.shivamdev.kotlinexample.utils.toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvForecast: RecyclerView = find(R.id.rv_forcast_list)
        rvForecast.layoutManager = LinearLayoutManager(this)
        //rvForecast.adapter = ForecastAdapter(dataItems)
        //toast("List loaded")
        toast("List loaded")
        doAsync {
            val result = RequestForecastCommand("560076").execute()
            uiThread {
                rvForecast.adapter = ForecastAdapter(result, object : OnItemClickListener {
                    override fun invoke(forecast: Forecast) {
                        toast(forecast.date)
                    }
                })
            }
        }
    }

    private val dataItems = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )
}