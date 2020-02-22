package com.source.countries.listcountries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.source.countries.R
import com.source.countries.listcountries.model.CountryItem
import kotlinx.android.synthetic.main.item_country_list.view.*


/*
* We could use DataBinding or ViewBinding but this view is so simple i decided not to
* Creating anonymous ViewHolder is possible due to kotlin syntactic extensions
* So i also omitted view holder
* */
class ListCountryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<CountryItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country_list, parent, false)

        return object : RecyclerView.ViewHolder(layout) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[holder.adapterPosition]
        with(holder.itemView) {
            name.text = item.name
            phoneNumberCode.text = item.callingCodes.joinToString()
            domainName.text = item.topLevelDomain.joinToString()
        }
    }
}