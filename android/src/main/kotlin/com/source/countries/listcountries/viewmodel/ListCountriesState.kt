package com.source.countries.listcountries.viewmodel

import com.source.countries.listcountries.model.CountryItem
import com.source.countries.listcountries.model.toItemList
import com.source.countries.listcountries.model.Country

data class ListCountriesState(
    val countries: List<CountryItem> = emptyList(),
    val error: Throwable? = null,
    val isErrorShow: Boolean = false,
    val isLoading: Boolean = false
) {
    companion object {
        @Suppress("NOTHING_TO_INLINE")
        inline fun loaded(countries: List<Country>): ListCountriesState {
            return ListCountriesState(countries = countries.toItemList())
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