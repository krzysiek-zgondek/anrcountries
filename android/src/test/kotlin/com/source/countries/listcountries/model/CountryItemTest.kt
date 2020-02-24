package com.source.countries.listcountries.model

import org.junit.Assert.*
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class CountryItemTest {
    private val countries = listOf(
        Country("1", listOf("1"), listOf("1"), listOf(Currency("1", "1", "1"))),
        Country("2", listOf("2"), listOf("2"), listOf(Currency("2", "2", "2")))
    )

    private val countriesItems = listOf(
        CountryItem(
            0L,
            "1",
            OffsetDateTime.now(),
            listOf("1"),
            listOf("1"),
            listOf(CurrencyItem(0L, "1", "1", "1"))
        ).fabricateDates(),
        CountryItem(
            0L,
            "2",
            OffsetDateTime.now(),
            listOf("2"),
            listOf("2"),
            listOf(CurrencyItem(0L, "2", "2", "2"))
        ).fabricateDates()
    )

    @Test
    fun `toItem converter should return correct item`() {
        val model = countries[0].toItem().fabricateDates()
        assertEquals(countriesItems[0], model)
    }

    @Test
    fun `toItemList converter should return correct item`() {
        val list = countries
            .toItemList()
            .map { model -> model.fabricateDates() }

        assertEquals(countriesItems, list)
    }

    @Test
    fun `toModel converter should return correct item`() {
        val model = countries[0].toModel().fromModel().toItem().fabricateDates()
        assertEquals(countriesItems[0], model)
    }

    @Test
    fun `toModelList fromModelList should return same list`() {
        val list = countries
            .toModelList()
            .fromModelList()
            .toItemList()
            .map { model -> model.fabricateDates() }

        assertEquals(countriesItems, list)
    }

    private fun CountryItem.fabricateDates(dateTime: OffsetDateTime = OffsetDateTime.MIN): CountryItem {
        return copy(createdAt = dateTime)
    }
}