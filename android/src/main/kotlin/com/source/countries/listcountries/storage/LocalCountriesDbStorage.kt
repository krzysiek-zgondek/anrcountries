package com.source.countries.listcountries.storage

import com.source.countries.listcountries.LocalCountryStorage
import com.source.countries.listcountries.model.*
import io.objectbox.Box


class LocalCountriesDbStorage(private val countryBox: Box<CountryItem>) : LocalCountryStorage {
    override fun getAllCountries(): List<CountryModel> {
        return countryBox.all.toModelList()
    }

    override fun setAllCountries(countries: List<CountryModel>) {
        countryBox.removeAll()
        countryBox.put(countries.fromModelList().toItemList())
    }
}