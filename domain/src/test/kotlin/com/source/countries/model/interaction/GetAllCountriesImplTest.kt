package com.source.countries.model.interaction

import com.source.countries.common.mock
import com.source.countries.model.repository.CountryRepository
import org.junit.Test
import org.mockito.Mockito


class GetAllCountriesImplTest {
    @Test
    fun `Get all countries should call repository`() {
        val repository: CountryRepository = mock()
        val getAllCountries = GetAllCountriesImpl(repository)

        getAllCountries()
        Mockito.verify(repository).getAllCountries()
    }
}