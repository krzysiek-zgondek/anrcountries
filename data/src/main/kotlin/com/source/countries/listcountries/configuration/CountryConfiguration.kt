package com.source.countries.listcountries.configuration

import com.source.countries.listcountries.interaction.GetAllCountries
import com.source.countries.listcountries.interaction.GetAllCountriesImpl
import com.source.countries.listcountries.repository.*
import com.source.countries.listcountries.service.CountryService
import org.koin.dsl.module
import org.threeten.bp.Duration
import retrofit2.Retrofit


val CountryConfiguration = module {
    //interactions
    factory<GetAllCountries> { GetAllCountriesImpl(get()) }

    //repositories
    single<CountryRepository> { CountryRepositoryImpl(get(), get()) }

    factory<LocalCountryRepository> {
        PersistentCountryRepository(
            get(),
            dataLifeTime = Duration.ofDays(1)
        )
    }

    //services
    single {
        get<Retrofit>().create(CountryService::class.java)
    }
}