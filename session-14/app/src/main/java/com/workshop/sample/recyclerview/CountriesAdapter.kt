package com.workshop.sample.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.workshop.sample.R

class CountriesAdapter(
    private val items: List<Country>,
    private val onCountryListItemClickListener: OnCountryListItemClickListener
) :
    RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CountryViewHolder {
        val view = when (p1) {
            VIEW_ITEM_TYPE_1 -> {
                LayoutInflater.from(p0.context).inflate(R.layout.item_country_list_item, p0, false)
            }
            VIEW_ITEM_TYPE_2 -> {
                LayoutInflater.from(p0.context).inflate(R.layout.item_country_list_item_2, p0, false)
            } else -> {
                throw Exception("Invalid view type")
            }
        }
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> {
                VIEW_ITEM_TYPE_1
            }
            else -> {
                VIEW_ITEM_TYPE_2
            }
        }
    }

    override fun onBindViewHolder(viewHolder: CountryViewHolder, p1: Int) {
        viewHolder.bind(items[p1], onCountryListItemClickListener)
    }

    companion object {
        const val VIEW_ITEM_TYPE_1 = 189
        const val VIEW_ITEM_TYPE_2 = 998
    }

}