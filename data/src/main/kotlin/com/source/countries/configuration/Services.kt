package com.source.countries.configuration

import com.source.countries.service.CountryService
import org.koin.dsl.module
import retrofit2.Retrofit

val Services = module {
    single {
        get<Retrofit>().create(CountryService::class.java)
    }
}