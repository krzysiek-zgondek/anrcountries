package com.source.countries.repository

import com.source.countries.common.time.filterOutdated
import com.source.countries.model.CountryModel
import com.source.countries.model.fromModelList
import com.source.countries.model.model.Country
import com.source.countries.model.toModelList
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

