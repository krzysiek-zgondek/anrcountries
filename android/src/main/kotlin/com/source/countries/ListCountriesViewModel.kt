package com.source.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.source.countries.model.CountryModel
import com.source.countries.model.toModelList
import kotlinx.coroutines.flow.map

class ListCountriesViewModel(
    private val repository: CountryRepository
) : ViewModel() {
    private var countries: MutableLiveData<List<CountryModel>>? = null

    fun getCountries(): LiveData<List<CountryModel>> {
        return countries ?: requestCountries()
    }

    private fun requestCountries(): LiveData<List<CountryModel>> {
        return repository
            .getAllCountries()
            .map { countries -> countries.toModelList() }
            .asLiveData()
    }
}