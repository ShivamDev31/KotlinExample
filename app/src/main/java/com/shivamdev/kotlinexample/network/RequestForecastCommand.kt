package com.shivamdev.kotlinexample.network

import com.shivamdev.kotlinexample.domain.Command
import com.shivamdev.kotlinexample.domain.ForecastDataMapper
import com.shivamdev.kotlinexample.domain.model.ForecastList

/**
 * Created by shivam on 20/1/17.
 */

class RequestForecastCommand(val zipcode : String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}