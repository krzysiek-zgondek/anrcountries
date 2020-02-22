package com.source.countries.listcountries.model

import org.junit.Assert.*
import org.junit.Test


class CountryModelTest {
    /*
    * Normally you would set those in @Before annotated method, but since in all provided classes
    * every field is immutable and list are immutable also there is no need to
    * */
    private val countries = listOf(
        Country("1", listOf("1"), listOf("1"), listOf(Currency("1", "1", "1"))),
        Country("2", listOf("2"), listOf("2"), listOf(Currency("2", "2", "2")))
    )

    private val countriesModels = listOf(
        CountryModel("1", listOf("1"), listOf("1"), listOf(CurrencyModel("1", "1", "1"))),
        CountryModel("2", listOf("2"), listOf("2"), listOf(CurrencyModel("2", "2", "2")))
    )

    @Test
    fun `toModel converter should return correct model`() {
        //create model but omit force the date
        val model = countries[0].toModel().copy(createdAt = countriesModels[0].createdAt)
        assertEquals(countriesModels[0], model)
    }

    @Test
    fun `toModel fromModel should return same item`() {
        //create model but omit force the date
        val item = countries[0].toModel().fromModel()
        assertEquals(countries[0], item)
    }

    @Test
    fun `toModelList converter should return correct model`() {
        val list = countries.toModelList().mapIndexed { index, model ->
            //create model but omit force the date
            model.copy(createdAt = countriesModels[index].createdAt)
        }
        assertEquals(countriesModels, list)
    }

    @Test
    fun `toModelList fromModelList should return same list`() {
        val list = countries.toModelList().fromModelList()
        assertEquals(countries, list)
    }
}