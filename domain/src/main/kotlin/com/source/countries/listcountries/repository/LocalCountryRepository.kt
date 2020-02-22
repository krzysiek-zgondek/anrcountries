package com.source.countries.listcountries.repository

import com.source.countries.listcountries.model.Country

interface LocalCountryRepository{
    fun getAllCountries(): List<Country>
    fun setAllCountries(countries: List<Country>)
}