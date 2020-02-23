package com.source.countries.listcountries.viewmodel

import androidx.lifecycle.*
import com.source.countries.common.whenFailed
import com.source.countries.common.whenSuccessful
import com.source.countries.listcountries.interaction.GetAllCountries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListCountriesViewModel(
    private val getAllCountries: GetAllCountries,
    private val executionScope: CoroutineDispatcher = Dispatchers.Default
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

    private fun requestCountries(): LiveData<ListCountriesState> = liveData(executionScope) {
        emit(ListCountriesState.loading())

        getAllCountries().collect { result ->
            result.whenFailed { emit(ListCountriesState.error(it)) }
                .whenSuccessful { emit(ListCountriesState.loaded(it)) }
        }
    }
}