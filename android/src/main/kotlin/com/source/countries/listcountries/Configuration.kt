package com.source.countries.listcountries

import com.source.countries.listcountries.storage.LocalCountriesDbStorage
import com.source.countries.listcountries.viewmodel.ListCountriesViewModel
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val ListCountryConfiguration = module {
    single<LocalCountryStorage> {
        LocalCountriesDbStorage(get<BoxStore>().boxFor())
    }

    viewModel {
        ListCountriesViewModel(get())
    }
}