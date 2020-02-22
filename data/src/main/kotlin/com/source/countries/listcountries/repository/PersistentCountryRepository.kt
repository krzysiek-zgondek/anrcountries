package com.source.countries.listcountries.repository

import com.source.countries.common.time.filterOutdated
import com.source.countries.listcountries.LocalCountryStorage
import com.source.countries.listcountries.model.fromModelList
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.model.toModelList
import org.threeten.bp.Duration

class PersistentCountryRepository(
    private val storage: LocalCountryStorage,
    private val dataLifeTime: Duration = Duration.ofDays(1)
) : LocalCountryRepository {
    override fun getAllCountries(): List<Country> {
        return storage
            .getAllValidCountries()
            .filterOutdated(dataLifeTime) { it.createdAt }
            .fromModelList()
    }

    override fun setAllCountries(countries: List<Country>) {
        storage.setAllCountries(countries.toModelList())
    }
}

