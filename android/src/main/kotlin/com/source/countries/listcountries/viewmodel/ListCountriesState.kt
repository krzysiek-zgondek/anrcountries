package com.source.countries.listcountries.viewmodel

import com.source.countries.model.CountryModel

data class ListCountriesState(
    val countries: List<CountryModel> = emptyList(),
    val error: Throwable? = null,
    val isErrorShow: Boolean = false,
    val isLoading: Boolean = false
) {
    companion object {
        @Suppress("NOTHING_TO_INLINE")
        inline fun loaded(countries: List<CountryModel>): ListCountriesState {
            return ListCountriesState(countries = countries)
        }

        @Suppress("NOTHING_TO_INLINE")
        inline fun loading(): ListCountriesState {
            return ListCountriesState(isLoading = true)
        }

        @Suppress("NOTHING_TO_INLINE")
        inline fun error(reason: Throwable): ListCountriesState {
            return ListCountriesState(
                isErrorShow = true,
                error = reason
            )
        }
    }
}