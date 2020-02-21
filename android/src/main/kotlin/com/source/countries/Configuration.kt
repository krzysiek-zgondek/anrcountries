package com.source.countries

import com.source.countries.configuration.NetworkModule
import com.source.countries.configuration.Repositories
import com.source.countries.configuration.Services
import com.source.countries.configuration.ViewModels

val allModules = listOf(
    NetworkModule,
    Services,
    Repositories,
    ViewModels
)