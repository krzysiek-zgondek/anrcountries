package com.source.countries.listcountries

import com.source.countries.listcountries.model.CountryModel

/*
* Enables room to not be a part of data layer
* */
interface LocalCountryStorage {
    fun getAllCountries(): List<CountryModel>
    fun setAllCountries(countries: List<CountryModel>)
}