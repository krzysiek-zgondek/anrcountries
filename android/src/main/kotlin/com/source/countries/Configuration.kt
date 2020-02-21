package com.source.countries

import com.source.countries.retrofit.createRetrofit
import com.source.countries.service.CountryService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val CommonModule = module {
    single {
        createRetrofit(
            baseUrl = androidContext().getString(R.string.country_api),
            enableLogs = BuildConfig.DEBUG
        )
    }
}

val NetworkModule = module {
    single {
        get<Retrofit>().create(CountryService::class.java)
    }
}

val Repositories = module {
    single {
        CountryRepository(get())
    }
}

val ViewModels = module {
    viewModel {
        ListCountriesViewModel(get())
    }
}

val allModules = listOf(
    CommonModule,
    NetworkModule,
    Repositories,
    ViewModels
)