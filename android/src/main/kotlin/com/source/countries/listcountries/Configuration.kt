package com.source.countries.listcountries

import com.source.countries.listcountries.viewmodel.ListCountriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val ListCountryConfiguration = module {
    viewModel {
        ListCountriesViewModel(get())
    }
}