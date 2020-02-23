package com.source.countries.common.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


fun createHttpClient(enableLogs: Boolean = false): OkHttpClient {
    return OkHttpClient.Builder().run {
        if (enableLogs) {
            addInterceptor(createLoggingInterceptor())
        }
        retryOnConnectionFailure(true)
        build()
    }
}

private fun createLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}
