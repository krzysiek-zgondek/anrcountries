package com.source.countries.listcountries.repository

import com.source.countries.common.time.filterOutdated
import com.source.countries.listcountries.model.CountryModel
import com.source.countries.listcountries.model.fromModelList
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.model.toModelList
import org.threeten.bp.Duration

class PersistentCountryRepository(
    private val dataLifeTime: Duration = Duration.ofDays(1)
) : LocalCountryRepository {
    private var list = listOf<CountryModel>()

    override fun getAllCountries(): List<Country> {
        return list.filterOutdated(dataLifeTime) { it.createdAt }.fromModelList()
    }

    override fun setAllCountries(countries: List<Country>) {
        list = countries.toModelList()
    }
}

