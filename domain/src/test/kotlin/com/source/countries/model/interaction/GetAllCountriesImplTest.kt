package com.source.countries.model.interaction

import com.source.countries.common.mock
import com.source.countries.model.common.Resource
import com.source.countries.model.common.resource
import com.source.countries.model.model.Country
import com.source.countries.model.repository.CountryRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito


class GetAllCountriesImplTest {
    private val expectedCountryList = listOf(
        Country("Poland", null, null, null),
        Country("Ukraine", null, null, null)
    )

    /**
     * This is a kind of test i really don't like because it locks internal
     * implementation
     * */
    @Test
    fun `Get all countries should call repository`() {
        val repository: CountryRepository = mock()
        val getAllCountries = GetAllCountriesImpl(repository)

        getAllCountries()
        Mockito.verify(repository).getAllCountries()
    }

    /**
     * This is a kind of test which really test sth
     * */
    @Test
    fun `Get all countries should return all provided elements`() {
        val repository: CountryRepository = mock()
        Mockito.`when`(repository.getAllCountries()).thenReturn(
            flow { emit(resource { expectedCountryList }) }
        )

        val getAllCountries = GetAllCountriesImpl(repository)

        runBlocking {
            val results = getAllCountries().toList()
            val countries = (results[0] as Resource.Success).value

            assertEquals(1, results.size)
            assertEquals(expectedCountryList, countries)
        }


    }
}