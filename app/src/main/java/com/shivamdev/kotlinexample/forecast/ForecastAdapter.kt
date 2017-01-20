package com.shivamdev.kotlinexample.forecast

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.shivamdev.kotlinexample.R
import com.shivamdev.kotlinexample.domain.model.Forecast
import com.shivamdev.kotlinexample.domain.model.ForecastList
import com.shivamdev.kotlinexample.listeners.OnItemClickListener
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick
import timber.log.Timber

/**
 * Created by shivam on 13/1/17.
 */

class ForecastAdapter(val weekForecast: ForecastList, val itemClick: OnItemClickListener)
    : RecyclerView.Adapter<ForecastAdapter.ForecastHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ForecastHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ForecastHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount()  : Int {
        val size = weekForecast.size()
        Timber.i("List size : %s", size)
        return size
    }

    class ForecastHolder(val view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val ivIcon: ImageView = view.find(R.id.icon)
        private val tvDate: TextView = view.find(R.id.date)
        private val tvDesc: TextView = view.find(R.id.description)
        private val tvMinTemp: TextView = view.find(R.id.minTemperature)
        private val tvMaxText: TextView = view.find(R.id.maxTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(view.context).load(iconUrl).into(ivIcon)
                tvDate.text = date
                tvDesc.text = description
                tvMinTemp.text = "$low"
                tvMaxText.text = "$high"
                view.onClick { itemClick(this) }
            }
        }
    }
}