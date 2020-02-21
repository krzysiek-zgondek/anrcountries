package com.source.countries.repository

import com.source.countries.model.CountryModel
import com.source.countries.model.common.Resource
import com.source.countries.model.model.Country
import com.source.countries.model.repository.CountryRepository
import kotlinx.coroutines.flow.Flow

interface LocalCountryRepository{
    fun getAllCountries(): List<Country>
    fun setAllCountries(countries: List<Country>)
}