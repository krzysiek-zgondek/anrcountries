package com.source.countries.listcountries.storage

import com.source.countries.common.mock
import com.source.countries.listcountries.model.CountryItem
import com.source.countries.listcountries.model.CountryItemDao
import com.source.countries.listcountries.model.CurrencyItem
import com.source.countries.listcountries.model.toModelList
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.threeten.bp.OffsetDateTime

class LocalCountriesDbStorageTest {
    private val countries = listOf(
        CountryItem(
            0L,
            "1",
            OffsetDateTime.MIN,
            listOf("1"),
            listOf("1"),
            listOf(CurrencyItem(0L, "1", "1", "1"))
        ),
        CountryItem(
            0L,
            "2",
            OffsetDateTime.MIN,
            listOf("2"),
            listOf("2"),
            listOf(CurrencyItem(0L, "2", "2", "2"))
        )
    )

    lateinit var storage: LocalCountriesDbStorage
    lateinit var dao: CountryItemDao

    @Before
    fun setup() {
        dao = mock()
        storage = LocalCountriesDbStorage(dao)
    }

    @Test
    fun `storage getAllCountries returns all stored elements without modification`() {
        Mockito.`when`(dao.all()).thenReturn(countries)
        val resulted = storage.getAllCountries()
        Assert.assertEquals(countries.toModelList(), resulted)
    }

    @Test
    fun `storage setAllCountries clears cache before storing new data`() {
        storage.setAllCountries(countries.toModelList())

        Mockito.verify(dao).removeAll()
    }
}