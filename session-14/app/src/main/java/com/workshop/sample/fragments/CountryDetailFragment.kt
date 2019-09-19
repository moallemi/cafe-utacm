package com.workshop.sample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.workshop.sample.R

class CountryDetailFragment : Fragment() {

    var name: String? = null
    var capital: String? = null
    var currency: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = arguments?.getString(KEY_COUNTRY_NAME)
        capital = arguments?.getString(KEY_COUNTRY_CAPITAL)
        currency = arguments?.getString(KEY_COUNTRY_CURRENCY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_country_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTV = view.findViewById<TextView>(R.id.nameTextView)
        val capitalTV = view.findViewById<TextView>(R.id.capitalTextView)
        val currencyTV = view.findViewById<TextView>(R.id.currencyTextView)

        nameTV.text = name
        capitalTV.text = capital
        currencyTV.text = currency
    }


    companion object {
        fun newInstance(name: String, capital: String, currency: String): CountryDetailFragment {
            val fragment = CountryDetailFragment()

            val bundle = Bundle()
            bundle.putString(KEY_COUNTRY_NAME, name)
            bundle.putString(KEY_COUNTRY_CAPITAL, capital)
            bundle.putString(KEY_COUNTRY_CURRENCY, currency)

            fragment.arguments = bundle

            return fragment
        }

        private const val KEY_COUNTRY_NAME = "country_name"
        private const val KEY_COUNTRY_CAPITAL = "country_capital"
        private const val KEY_COUNTRY_CURRENCY = "country_currency"
    }

}