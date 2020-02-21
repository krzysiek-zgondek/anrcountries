package com.source.countries.configuration

import com.source.countries.model.interaction.GetAllCountries
import com.source.countries.model.interaction.GetAllCountriesImpl
import com.source.countries.model.repository.CountryRepository
import com.source.countries.repository.CountryRepositoryImpl
import com.source.countries.repository.LocalCountryRepository
import com.source.countries.repository.PersistentCountryRepository
import com.source.countries.service.CountryService
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
            dataLifeTime = Duration.ofSeconds(
                15
            )
        )
    }

    //services
    single { get<Retrofit>().create(CountryService::class.java) }
}