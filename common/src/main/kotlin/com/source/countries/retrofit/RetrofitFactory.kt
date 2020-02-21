package com.source.countries.retrofit

import com.source.countries.moshi.createMoshiConverter
import com.source.countries.okhttp.createHttpClient
import retrofit2.Retrofit


fun createRetrofit(baseUrl: String, enableLogs: Boolean = false): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(createHttpClient(enableLogs))
        .addConverterFactory(createMoshiConverter())
        .build()
}