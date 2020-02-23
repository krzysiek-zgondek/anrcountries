package com.source.countries.listcountries.storage

import com.source.countries.common.mock
import com.source.countries.listcountries.model.CountryItem
import com.source.countries.listcountries.model.CurrencyItem
import com.source.countries.listcountries.model.countryItem
import com.source.countries.listcountries.model.toModelList
import io.objectbox.Box
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.threeten.bp.OffsetDateTime

class LocalCountriesDbStorageTest {
    private val countries = listOf(
        countryItem(
            "1",
            OffsetDateTime.MIN,
            listOf("1"),
            listOf("1"),
            listOf(CurrencyItem(0L, "1", "1", "1"))
        ),
        countryItem(
            "2",
            OffsetDateTime.MIN,
            listOf("2"),
            listOf("2"),
            listOf(CurrencyItem(0L, "2", "2", "2"))
        )
    )

    lateinit var storage: LocalCountriesDbStorage
    lateinit var box: Box<CountryItem>

    @Before
    fun setup() {
        box = mock()
        storage = LocalCountriesDbStorage(box)
    }

    @Test
    fun `storage getAllCountries returns all stored elements without modification`() {
        Mockito.`when`(box.all).thenReturn(countries)
        val resulted = storage.getAllCountries()
        Assert.assertEquals(countries.toModelList(), resulted)
    }

    @Test
    fun `storage setAllCountries clears cache before storing new data`() {
        storage.setAllCountries(countries.toModelList())

        Mockito.verify(box).removeAll()
    }
}