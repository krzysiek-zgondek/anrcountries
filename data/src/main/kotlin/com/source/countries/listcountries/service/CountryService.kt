package com.source.countries.listcountries.service

import com.source.countries.listcountries.model.Country
import retrofit2.http.GET


interface CountryService{
    @GET("rest/v2/all")
    suspend fun countries(): List<Country>
}