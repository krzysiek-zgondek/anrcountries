package com.source.countries.service

import com.source.countries.model.model.Country
import retrofit2.http.GET


interface CountryService{
    @GET("rest/v2/all")
    suspend fun countries(): List<Country>
}