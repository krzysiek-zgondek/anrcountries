package com.source.countries

import com.source.countries.configuration.countryServiceConfiguration
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @project Countries
 * @author SourceOne on 21.02.2020
 */

val CommonModule = module {
    factory {
        MoshiConverterFactory.create()
    }
}

val NetworkModule = module {
    single {
        countryServiceConfiguration()
    }
}

val allModules = listOf(
    CommonModule,
    NetworkModule
)