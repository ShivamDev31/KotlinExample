package com.shivamdev.kotlinexample.domain

import com.shivamdev.kotlinexample.data.Forecast
import com.shivamdev.kotlinexample.data.ForecastResult
import com.shivamdev.kotlinexample.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.shivamdev.kotlinexample.domain.model.Forecast as ModelForecast


/**
 * Created by shivam on 20/1/17.
 */
 class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecastItem: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecastItem.dt), forecastItem.weather[0].description,
                forecastItem.temp.max.toInt(), forecastItem.temp.min.toInt(),
                generateIconUrl(forecastItem.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String =
            "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}