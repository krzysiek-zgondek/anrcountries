package com.source.countries.configuration

import com.source.countries.model.repository.CountryRepository
import com.source.countries.repository.CountryRepositoryImpl
import org.koin.dsl.module

val Repositories = module {
    single<CountryRepository> {
        CountryRepositoryImpl(get())
    }
}

