package com.source.countries.listcountries.model

import org.junit.Assert.*
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class CurrencyItemTest {
    private val currencies = listOf(
        Currency("1", "1", "1"),
        Currency("2", "2", "2")
    )

    private val currenciesItems = listOf(
        CurrencyItem(0L, "1", "1", "1"),
        CurrencyItem(0L, "2", "2", "2")
    )

    @Test
    fun `toItem converter should return correct item`() {
        val model = currencies[0].toItem()
        assertEquals(currenciesItems[0], model)
    }

    @Test
    fun `toItem chain should return same item`() {
        val item = currencies[0]
            .toItem()
            .toModel()
            .fromModel()
            .toItem()

        assertEquals(currencies[0], item)
    }

    /*
    * Basically same tests for model converters
    * */
}