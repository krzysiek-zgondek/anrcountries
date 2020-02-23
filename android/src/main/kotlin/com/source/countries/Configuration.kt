package com.source.countries

import com.source.countries.common.retrofit.createRetrofit
import com.source.countries.listcountries.ListCountryConfiguration
import com.source.countries.listcountries.configuration.CountryConfiguration
import com.source.countries.listcountries.model.MyObjectBox
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val CommonModules = module {
    //database
    single {
        MyObjectBox.builder()
            .androidContext(androidContext())
            .build()
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