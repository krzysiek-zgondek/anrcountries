package com.source.countries.listcountries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.source.countries.model.common.whenFailed
import com.source.countries.model.common.whenSuccessful
import com.source.countries.model.interaction.GetAllCountries
import com.source.countries.model.repository.CountryRepository
import com.source.countries.model.toModelList
import kotlinx.coroutines.flow.collect

class ListCountriesViewModel(
    private val getAllCountries: GetAllCountries
) : ViewModel() {
    private var state: LiveData<ListCountriesState>? = null

    fun getCountries(fresh: Boolean = false): LiveData<ListCountriesState> {
        resetStateWhenFreshRequested(fresh)

        return state ?: run {
            requestCountries().also { state = it }
        }
    }

    private fun resetStateWhenFreshRequested(fresh: Boolean) {
        if (fresh)
            state = null
    }

    private fun requestCountries(): LiveData<ListCountriesState> = liveData {
        emit(ListCountriesState.loading())

        getAllCountries().collect { result ->
            result.whenFailed { emit(ListCountriesState.error(it)) }
                .whenSuccessful { emit(ListCountriesState.loaded(it)) }
        }
    }
}