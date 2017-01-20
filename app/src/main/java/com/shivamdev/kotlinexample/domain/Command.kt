package com.shivamdev.kotlinexample.domain

/**
 * Created by shivam on 20/1/17.
 */

interface Command<out T> {
    fun execute() : T
}