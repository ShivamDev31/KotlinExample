//@file:JvmName("Logger")
package com.shivamdev.kotlinexample.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by shivam on 19/1/17.
 */

fun Context.toast(message : String = "Logger") {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}