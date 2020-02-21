package com.source.countries.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


fun createHttpClient(enableLogs: Boolean = false): OkHttpClient {
    return OkHttpClient.Builder().run {
        if (enableLogs) {
            addInterceptor(createLoggingInterceptor())
        }
        build()
    }
}

private fun createLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}
