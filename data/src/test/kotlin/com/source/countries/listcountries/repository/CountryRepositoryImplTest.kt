package com.source.countries.listcountries.repository

import com.source.countries.common.Resource
import com.source.countries.common.mock
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.model.Currency
import com.source.countries.listcountries.service.CountryService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class CountryRepositoryImplTest {
    /*
    * Kotlin creates all classes closed as default so you have to delegate those using open class
    * that can be mocked
    * */
    open class TestLocalRepo(val delegate: PersistentCountryRepository) :
        LocalCountryRepository by delegate

    private val countries = listOf(
        Country("1", listOf("1"), listOf("1"), listOf(Currency("1", "1", "1"))),
        Country("2", listOf("2"), listOf("2"), listOf(Currency("2", "2", "2")))
    )

    private val local = listOf(
        Country("1", listOf("1"), listOf("1"), listOf(Currency("1", "1", "1"))),
        Country("3", listOf("3"), listOf("3"), listOf(Currency("3", "3", "3")))
    )

    lateinit var serviceMock: CountryService

    @Before
    fun setup() {
        runBlocking {
            serviceMock = mock()
            Mockito.`when`(serviceMock.countries()).thenReturn(countries)
        }
    }

    @Test
    fun `repository get fresh data when local is empty`() {
        runBlocking {
            val localRepo: TestLocalRepo = mock()
            Mockito.`when`(localRepo.getAllCountries()).thenReturn(emptyList())

            val repo = CountryRepositoryImpl(serviceMock, localRepo)
            repo.getAllCountries().collect { resource ->
                resource as Resource.Success
                assertEquals(countries, resource.value)
            }
        }
    }

    @Test
    fun `repository returns local data when local is not empty`() {
        runBlocking {
            val localRepo: TestLocalRepo = mock()
            Mockito.`when`(localRepo.getAllCountries()).thenReturn(local)

            val repo = CountryRepositoryImpl(serviceMock, localRepo)
            repo.getAllCountries().collect { resource ->
                resource as Resource.Success
                assertEquals(local, resource.value)
            }
        }
    }
}