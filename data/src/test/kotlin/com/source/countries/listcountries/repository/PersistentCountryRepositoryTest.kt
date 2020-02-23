package com.source.countries.listcountries.repository

import com.source.countries.common.mock
import com.source.countries.listcountries.LocalCountryStorage
import com.source.countries.listcountries.model.CountryModel
import com.source.countries.listcountries.model.CurrencyModel
import com.source.countries.listcountries.model.fromModelList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.threeten.bp.OffsetDateTime


class PersistentCountryRepositoryTest {
    private val countries = listOf(
        CountryModel("1", listOf("1"), listOf("1"), listOf(CurrencyModel("1", "1", "1"))),
        CountryModel("2", listOf("2"), listOf("2"), listOf(CurrencyModel("2", "2", "2")))
    )

    private val invalidCountries = listOf(
        CountryModel(
            "1",
            listOf("1"),
            listOf("1"),
            listOf(CurrencyModel("1", "1", "1")),
            OffsetDateTime.MIN
        ),
        CountryModel(
            "2",
            listOf("2"),
            listOf("2"),
            listOf(CurrencyModel("2", "2", "2")),
            OffsetDateTime.MIN
        )
    )

    @Test
    fun `repository get valid countries gets all countries for valid duration`() {
        runBlocking {
            val localStorage: LocalCountryStorage = mock()
            Mockito.`when`(localStorage.getAllCountries()).thenReturn(countries)

            val localRepo = PersistentCountryRepository(localStorage)
            val result = localRepo.getAllCountries()
            assertEquals(countries.fromModelList(), result)
        }
    }

    @Test
    fun `repository get valid countries gets no countries for invalid duration`() {
        runBlocking {
            val localStorage: LocalCountryStorage = mock()
            Mockito.`when`(localStorage.getAllCountries()).thenReturn(invalidCountries)

            val localRepo = PersistentCountryRepository(localStorage)
            val result = localRepo.getAllCountries()
            assertEquals(emptyList<CountryModel>(), result)
        }
    }

}