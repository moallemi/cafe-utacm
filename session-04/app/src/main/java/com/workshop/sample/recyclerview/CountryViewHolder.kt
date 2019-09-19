package com.workshop.sample.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.workshop.sample.R

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.name)
    private val capitalTextView: TextView = itemView.findViewById(R.id.capital)

    fun bind(
        country: Country,
        onCountryListItemClickListener: OnCountryListItemClickListener
    ) {
        nameTextView.text = country.name
        capitalTextView.text = country.capital

        itemView.setOnClickListener {
            onCountryListItemClickListener.onItemClicked(country)
        }
    }

}