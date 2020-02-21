package com.source.countries.model.interaction

import com.source.countries.model.common.Resource
import com.source.countries.model.model.Country
import com.source.countries.model.repository.CountryRepository
import kotlinx.coroutines.flow.Flow


class GetAllCountriesImpl(private val repository: CountryRepository) : GetAllCountries {
    override fun invoke(): Flow<Resource<List<Country>>> {
        return repository.getAllCountries()
    }
}
