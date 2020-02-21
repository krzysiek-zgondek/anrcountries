package com.source.countries.model.repository

import com.source.countries.model.common.Resource
import com.source.countries.model.model.Country
import kotlinx.coroutines.flow.Flow


interface CountryRepository {
    fun getAllCountries(): Flow<Resource<List<Country>>>
}