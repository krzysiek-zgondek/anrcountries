package com.source.countries.listcountries.repository

import com.source.countries.common.Resource
import com.source.countries.listcountries.model.Country
import kotlinx.coroutines.flow.Flow


interface CountryRepository {
    fun getAllCountries(): Flow<Resource<List<Country>>>
}