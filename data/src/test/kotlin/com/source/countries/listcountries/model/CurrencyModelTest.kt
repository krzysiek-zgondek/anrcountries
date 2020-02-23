package com.source.countries.listcountries.model

import org.junit.Assert.*
import org.junit.Test


class CurrencyModelTest {
    private val currencies = listOf(
        Currency("1", "1", "1"),
        Currency("2", "2", "2")
    )

    private val currenciesModels = listOf(
        CurrencyModel("1", "1", "1"),
        CurrencyModel("2", "2", "2")
    )

    @Test
    fun `toModel converter should return correct model`() {
        val model = currencies[0].toModel()
        assertEquals(currenciesModels[0], model)
    }

    @Test
    fun `toModel fromModel should return same item`() {
        val item = currencies[0].toModel().fromModel()
        assertEquals(currencies[0], item)
    }

    @Test
    fun `toModelList converter should return correct model`() {
        val list = currencies.toModelList()
        assertEquals(currenciesModels, list)
    }

    @Test
    fun `toModelList fromModelList should return same list`() {
        val list = currencies.toModelList().fromModelList()
        assertEquals(currencies, list)
    }
}