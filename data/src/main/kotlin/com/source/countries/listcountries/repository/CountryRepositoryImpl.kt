package com.source.countries.listcountries.repository

import com.source.countries.common.Resource
import com.source.countries.common.whenSuccessful
import com.source.countries.common.resource
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.service.CountryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class CountryRepositoryImpl(
    private val countryService: CountryService,
    private val countryLocalRepository: LocalCountryRepository
) : CountryRepository {

    override fun getAllCountries(): Flow<Resource<List<Country>>> {
        return flow {
            val cached = countryLocalRepository.getAllCountries()
            if (cached.isNotEmpty()) {
                emit(resource { cached })
            } else {
                val resource = requestCountries()
                resource.whenSuccessful { countries ->
                    countryLocalRepository.setAllCountries(countries)
                }
                emit(resource)
            }
        }
    }

    private suspend fun requestCountries(): Resource<List<Country>> {
        return resource {
            countryService.countries()
        }
    }
}