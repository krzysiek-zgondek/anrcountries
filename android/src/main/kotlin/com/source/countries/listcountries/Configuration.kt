package com.source.countries.listcountries

import com.source.countries.CountriesDatabase
import com.source.countries.listcountries.storage.LocalCountriesDbStorage
import com.source.countries.listcountries.viewmodel.ListCountriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val ListCountryConfiguration = module {
    single<LocalCountryStorage> {
        LocalCountriesDbStorage(get<CountriesDatabase>().countryDao())
    }

    viewModel {
        ListCountriesViewModel(get())
    }
}