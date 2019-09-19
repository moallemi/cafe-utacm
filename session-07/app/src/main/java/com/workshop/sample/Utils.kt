package com.workshop.sample

import android.content.Context

object CountriesDataSource {

    fun get(context: Context): String {
        val text = context.resources.openRawResource(R.raw.countries)
            .bufferedReader()
            .use {
                it.readText()
            }
        return text
    }
}