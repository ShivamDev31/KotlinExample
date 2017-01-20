package com.shivamdev.kotlinexample.listeners

import com.shivamdev.kotlinexample.domain.model.Forecast

/**
 * Created by shivam on 20/1/17.
 */

interface OnItemClickListener {
    operator fun invoke(forecast : Forecast)
}