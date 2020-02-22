package com.source.countries.listcountries.interaction

import com.source.countries.common.Resource
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.repository.CountryRepository
import kotlinx.coroutines.flow.Flow


class GetAllCountriesImpl(private val repository: CountryRepository) : GetAllCountries {
    override fun invoke(): Flow<Resource<List<Country>>> {
        return repository.getAllCountries()
    }
}
