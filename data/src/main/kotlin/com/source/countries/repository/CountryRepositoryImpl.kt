package com.source.countries.repository

import com.source.countries.model.common.Resource
import com.source.countries.model.common.whenSuccessful
import com.source.countries.model.common.resource
import com.source.countries.model.model.Country
import com.source.countries.model.repository.CountryRepository
import com.source.countries.service.CountryService
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