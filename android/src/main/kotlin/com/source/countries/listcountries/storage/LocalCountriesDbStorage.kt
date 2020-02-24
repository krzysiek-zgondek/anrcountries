package com.source.countries.listcountries.storage

import com.source.countries.listcountries.LocalCountryStorage
import com.source.countries.listcountries.model.*


class LocalCountriesDbStorage(private val countryDao: CountryItemDao) : LocalCountryStorage {
    override fun getAllCountries(): List<CountryModel> {
        return countryDao.all().toModelList()
    }

    override fun setAllCountries(countries: List<CountryModel>) {
        countryDao.removeAll()
        countryDao.insertAll(countries.fromModelList().toItemList())
    }
}