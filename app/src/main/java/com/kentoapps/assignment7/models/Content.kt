package com.kentoapps.assignment7.models

import java.util.*

/**
 * Created by kento on 2017/09/26.
 */

data class Content(var date: Date, var body: String, var imageUrl1: String, var imageUrl2: String) {
    fun isOlderThan5years(): Boolean {
        val cal = Calendar.getInstance()
        cal.time = Date()
        val currentYear = cal.get(Calendar.YEAR)
        cal.time = date
        val movieYear = cal.get(Calendar.YEAR)
        return currentYear - movieYear > 5
    }

    fun getYear(): Int {
        val cal = Calendar.getInstance()
        cal.time = date
        return cal.get(Calendar.YEAR)
    }
}
