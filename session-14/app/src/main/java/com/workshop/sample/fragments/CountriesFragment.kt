package com.workshop.sample.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshop.sample.CountriesDataSource
import com.workshop.sample.R
import com.workshop.sample.recyclerview.CountriesAdapter
import com.workshop.sample.recyclerview.Country
import com.workshop.sample.recyclerview.OnCountryListItemClickListener
import org.json.JSONArray

class CountriesFragment : Fragment(), OnCountryListItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countriesString = CountriesDataSource.get(view.context)
        val data = JSONArray(countriesString)

        val countries = ArrayList<Country>()
        for (i in 0 until data.length()) {
            val name = data.getJSONObject(i).getJSONObject("name").getString("official")
            val capital = data.getJSONObject(i).getJSONArray("capital").optString(0) ?: "Unknown"
            val currency = data.getJSONObject(i).getJSONArray("currency").optString(0) ?: "Unknown"
            val country = Country(name, capital, currency)
            countries.add(country)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = CountriesAdapter(countries, this)
    }

    override fun onItemClicked(country: Country) {
        val detailFragment =
            CountryDetailFragment.newInstance(country.name, country.capital, country.currency)

        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.content_frame, detailFragment)
            ?.commit()
    }

}
