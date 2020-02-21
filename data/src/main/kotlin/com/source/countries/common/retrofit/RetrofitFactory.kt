package com.source.countries.common.retrofit

import com.source.countries.common.moshi.createMoshiConverter
import com.source.countries.common.okhttp.createHttpClient
import retrofit2.Retrofit


fun createRetrofit(baseUrl: String, enableLogs: Boolean = false): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(createHttpClient(enableLogs))
        .addConverterFactory(createMoshiConverter())
        .build()
}