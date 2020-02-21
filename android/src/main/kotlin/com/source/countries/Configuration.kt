package com.source.countries

import com.source.countries.common.retrofit.createRetrofit
import com.source.countries.configuration.CountryConfiguration
import com.source.countries.listcountries.ListCountryConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val NetworkModule = module {
    single {
        createRetrofit(
            baseUrl = androidContext().getString(R.string.country_api),
            enableLogs = BuildConfig.DEBUG
        )
    }
}

val allModules = listOf(
    NetworkModule,
    CountryConfiguration,
    ListCountryConfiguration
)