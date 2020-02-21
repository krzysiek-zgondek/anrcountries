package com.source.countries.configuration

import com.source.countries.listcountries.viewmodel.ListCountriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModels = module {
    viewModel {
        ListCountriesViewModel(get())
    }
}