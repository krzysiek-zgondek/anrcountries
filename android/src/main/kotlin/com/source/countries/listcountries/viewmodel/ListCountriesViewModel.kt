package com.source.countries.listcountries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.source.countries.model.common.onFailed
import com.source.countries.model.common.onSuccess
import com.source.countries.model.repository.CountryRepository
import com.source.countries.model.toModelList
import kotlinx.coroutines.flow.collect

class ListCountriesViewModel(
    private val repository: CountryRepository
) : ViewModel() {
    private var state: LiveData<ListCountriesState>? = null

    fun getCountries(): LiveData<ListCountriesState> {
        return state ?: run {
            requestCountries().also { state = it }
        }
    }

    private fun requestCountries(): LiveData<ListCountriesState> = liveData {
        emit(ListCountriesState.loading())

        repository.getAllCountries().collect { result ->
            result.onFailed { emit(ListCountriesState.error(it)) }
                .onSuccess { emit(ListCountriesState.loaded(it.toModelList())) }
        }
    }
}