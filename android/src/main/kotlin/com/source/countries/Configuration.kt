package com.source.countries

import androidx.room.Room
import com.source.countries.common.retrofit.createRetrofit
import com.source.countries.listcountries.ListCountryConfiguration
import com.source.countries.listcountries.configuration.CountryConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val CommonModules = module {
    //database
    single {
        Room.databaseBuilder(
            androidContext(),
            CountriesDatabase::class.java,
            CountriesDatabase.Name
        ).build()
    }

    //networking
    single {
        createRetrofit(
            baseUrl = androidContext().getString(R.string.country_api),
            enableLogs = BuildConfig.DEBUG
        )
    }
}

val allModules = listOf(
    CommonModules,
    CountryConfiguration,
    ListCountryConfiguration
)