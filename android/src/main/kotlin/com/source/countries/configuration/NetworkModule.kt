package com.source.countries.configuration

import com.source.countries.BuildConfig
import com.source.countries.R
import com.source.countries.common.retrofit.createRetrofit
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