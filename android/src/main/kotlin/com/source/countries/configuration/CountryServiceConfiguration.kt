package com.source.countries.configuration

import com.source.countries.R
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun Scope.countryServiceConfiguration(): Retrofit {
    val baseUrl = androidContext().getString(R.string.country_api)

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(get<MoshiConverterFactory>())
        .build()
}