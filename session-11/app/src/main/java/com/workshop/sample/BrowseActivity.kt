package com.workshop.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.workshop.sample.fragments.CountriesFragment

class BrowseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brwose)

        val countriesFragment = CountriesFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame, countriesFragment)
            .commit()
    }
}
